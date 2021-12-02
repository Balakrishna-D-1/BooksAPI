package com.bookapi.books.Models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Data
@ToString
@Getter
@Setter
@Document(collection = "books")
public class AddBooks {
    @Id
    String id;
    String bookname;
    String bookauthor;
    String publishDate;
    List <Object> booktype;
    
}
