package com.bookapi.books.Controller.Auth;

import com.bookapi.books.DB.BookRepo;
import com.bookapi.books.Models.AddBooks;

import java.util.List;
import java.util.UUID;

import com.bookapi.books.response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class BookController {
    
    @Autowired
    BookRepo bookRepo;
    
    @PostMapping("/addb")
    public response doAddBooks(@RequestBody AddBooks books) {
        List<AddBooks>booklist =bookRepo.findAll();
        if(booklist.size()>0)
        {
            books.setId(UUID.randomUUID().toString());
            for(AddBooks books2:booklist) {
                if(books2.getBookname().equals(books.getBookname())) {
                    return new response(404, "Book Already exists", books);

                }
           
            }
            bookRepo.insert(books);

        }

        
    return new response(200, "Book Added succesfully", books);
    }
        @PostMapping("/editb")
        public response doeditBooks(@RequestBody AddBooks books) {
            if(bookRepo.existsById(books.getId())) {
                AddBooks book = bookRepo.findById(books.getId()).get();
                book.setBookname(books.getBookname());
                book.setBookauthor(books.getBookauthor());
                bookRepo.save(book);
                return new response(200, "edited succesfully", book);
            }
            return new response(404, "book not found", null);

        }
    @PostMapping("/deleteb")
        public response dodeleteBooks(@RequestBody AddBooks books) {
            if(bookRepo.existsById(books.getId())) {
                AddBooks book = bookRepo.findById(books.getId()).get();
                bookRepo.delete(book);
                return new response(200, "deleted succesfully", book);
            }
            return new response(404, "book already deleted", null);

        }
        @GetMapping("/books")
        List<AddBooks> all() {
            return bookRepo.findAll();
        }


}
