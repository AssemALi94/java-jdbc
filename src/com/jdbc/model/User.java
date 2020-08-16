package com.jdbc.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class User {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String roleId;


}
