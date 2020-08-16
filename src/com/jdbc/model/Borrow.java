package com.jdbc.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Borrow {
    private String idUser;
    private String idBook;
    private String status;

}
