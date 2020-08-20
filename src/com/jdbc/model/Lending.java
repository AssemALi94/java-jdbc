package com.jdbc.model;


import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class Lending {

    private long id;
    private long bookId;
    private long borrowerId;
    private long staffId;
    private Date lendDate;
    private Date returnDate;
    private boolean bookStatus;


}
