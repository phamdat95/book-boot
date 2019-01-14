package com.example.bootemo;

import com.example.bootemo.service.BookService;
import com.example.bootemo.service.CategoryService;
import com.example.bootemo.service.imp.BookServiceImp;
import com.example.bootemo.service.imp.CategoryServiceImp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BootemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootemoApplication.class, args);
	}
@Bean
	public BookService bookService(){return new BookServiceImp();
}
@Bean
	public CategoryService categoryService(){return new CategoryServiceImp();
}
}

