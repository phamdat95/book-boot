package com.example.bootemo.repository;

import com.example.bootemo.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends PagingAndSortingRepository<Book,Long> {
    Page<Book> findAllByBookCodeContaining(String code, Pageable pageable);
}
