package com.jdbc.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Rate {
    private String id;
    private String userId;
    private String bookId;
    private String rate;

}
