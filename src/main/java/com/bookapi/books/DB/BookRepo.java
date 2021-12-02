package com.bookapi.books.DB;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.*;

import com.bookapi.books.Models.AddBooks;

@Repository
public interface BookRepo extends MongoRepository<AddBooks,String>{
    
}
