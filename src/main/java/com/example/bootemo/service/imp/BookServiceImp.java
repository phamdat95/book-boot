package com.example.bootemo.service.imp;

import com.example.bootemo.model.Book;
import com.example.bootemo.repository.BookRepository;
import com.example.bootemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class BookServiceImp implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void remove(Long id) {
        bookRepository.delete(findById(id));
    }

    @Override
    public Page<Book> findByCode(String code, Pageable pageable) {
        return bookRepository.findAllByBookCodeContaining(code,pageable);
    }
}
