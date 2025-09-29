package com.api.book.bookrestbook.services;
import java.util.*;



import org.springframework.stereotype.Component;

import com.api.book.bookrestbook.Entities.Book;
import com.api.book.bookrestbook.dao.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // private static List<Book> list=new ArrayList<>();
    

    // static{
    //     list.add(new Book(12,"java book","abd"));
    //     list.add(new Book(123,"java book2","cg"));
    //     list.add(new Book(126,"java book1","msd"));
        

    // }
    public List<Book> getAllBooks(){
        List<Book> list=(List<Book>) this.bookRepository.findAll();
        return list;
    }

    public Book getBookById(int id){
        Book book=null;
        try{
            book=this.bookRepository.findById(id);
        }catch(Exception e){
            e.printStackTrace();
        }
        // book=list.stream().filter(e->e.getId()==id).findFirst().get();
        return book;
    }
    public Book addBook(Book b){
        // list.add(b);
        Book result=this.bookRepository.save(b);
        return result;
    }

    public void deleteBook(int bid){
        // list=list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
        bookRepository.deleteById(bid);
    }
    public void updateBook(Book book,int bookId){
        // list=list.stream().map(b->{
        //   if(b.getId()==bookId){

    //     //     b.setTitle(book.getTitle());
    //     //     b.setAuthor(book.getAuthor());
            
    //     //   }
        //   return b;



    //     // }).collect(Collectors.toList());
        book.setId(bookId);
        bookRepository.save(book);
    }

    
}
