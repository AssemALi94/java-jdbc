package com.jdbc.model;

import lombok.AllArgsConstructor;
import lombok.Data;

//@AllArgsConstructor
@Data
public class Lending {
    private long id;
    private long bookId;
    private long borrowerId;
    private long staffId;
    private String lendDate;
    private String returnDate;
    private String bookStatus;

}
