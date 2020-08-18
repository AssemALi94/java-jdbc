package com.jdbc.model;


import lombok.AllArgsConstructor;
import lombok.Data;

//@AllArgsConstructor
@Data
public class Rate {
    private long id;
    private long userId;
    private long bookId;
    private String score;

}
