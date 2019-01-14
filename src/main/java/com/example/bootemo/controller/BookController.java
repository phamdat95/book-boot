package com.example.bootemo.controller;

import com.example.bootemo.model.Book;
import com.example.bootemo.model.Category;
import com.example.bootemo.service.BookService;
import com.example.bootemo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;


@Controller
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;
    @ModelAttribute("category")
    public Iterable<Category> getCategory(){
        return categoryService.findAll();
    }

    @GetMapping("list")
    public ModelAndView showListBook(@PageableDefault(size = 5) Pageable pageable,@RequestParam("search") Optional<String> search){
        ModelAndView modelAndView = new ModelAndView("list");
        Page<Book> books;
        if (!search.isPresent()){
            books = bookService.findAll(pageable);
        }else {
            books = bookService.findByCode(search.get(), pageable);
            modelAndView.addObject("search", search.get());
        }
        modelAndView.addObject("book", books);
        return modelAndView;
    }
    @GetMapping("create")
    public ModelAndView showCreateForm(){
        return new ModelAndView("create","book",new Book());
    }
    @PostMapping("create")
    public ModelAndView createBook(@Validated @ModelAttribute("book") Book book, BindingResult result){
        ModelAndView modelAndView = new ModelAndView("create");
        if (result.hasFieldErrors()){
            modelAndView.addAllObjects(result.getModel());
            return modelAndView;
        } else {
            bookService.save(book);
            modelAndView.addObject("message","success");
            return modelAndView;
        }
    }
    @GetMapping("edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Book book = bookService.findById(id);
        return new ModelAndView("edit","book",book);
    }
    @PostMapping("edit")
    public ModelAndView editBook(@Validated @ModelAttribute("book") Book book, BindingResult result){
        ModelAndView modelAndView = new ModelAndView("edit");
        if (result.hasFieldErrors()){
            modelAndView.addAllObjects(result.getModel());
            return modelAndView;
        }else {
            bookService.save(book);
            modelAndView.addObject("message","successful");
            return modelAndView;
        }
    }
    @GetMapping("delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Book book = bookService.findById(id);
        return new ModelAndView("delete","book",book);
    }
    @PostMapping("delete")
    public ModelAndView deleteBook(@ModelAttribute("book") Book book){
        bookService.remove(book.getId());
        return new ModelAndView("redirect:list");
    }

}
