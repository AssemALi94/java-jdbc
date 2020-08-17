package com.jdbc.model;


import lombok.AllArgsConstructor;
import lombok.Data;

//@AllArgsConstructor
@Data
public class Book {
    private long id;
    private String bookName;
    private String authorName;
    private String idCategory;
}
