package com.jdbc.model;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Lending {

    private long id;
    private long bookId;
    private long borrowerId;
    private long staffId;
    private String lendDate;
    private String returnDate;
    private boolean bookStatus;


}
