package com.api.book.bookrestbook.dao;

import org.springframework.data.repository.CrudRepository;
import com.api.book.bookrestbook.Entities.Book;

public interface BookRepository extends CrudRepository<Book,Integer>{
    
        public Book findById(int id);
    
    
}
