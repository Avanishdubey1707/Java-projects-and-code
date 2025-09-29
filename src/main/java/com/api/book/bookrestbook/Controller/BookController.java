package com.api.book.bookrestbook.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.bookrestbook.Entities.Book;
import com.api.book.bookrestbook.services.BookService;
import java.util.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
public class BookController {
     
    @Autowired
    private BookService bookService;
        @GetMapping("/books")
    public List<Book> getBook(){
     
        return this.bookService.getAllBooks();
    }
     
    @PostMapping("/books")      
    public Book addBook(@RequestBody Book book ){
        Book b= this.bookService.addBook(book);
        return b;
    }
     
    @DeleteMapping("/books/{bookId}")
    public void delBook(@PathVariable("bookId") int bookId){
        this.bookService.deleteBook(bookId);
    }
    @PutMapping("books/{bookId}")
    public Book upBook(@RequestBody Book book,@PathVariable ("bookId") int bookId){
        this.bookService.updateBook(book,bookId);
        return book;

    }


    
}
