package com.jdbc.model;

import com.jdbc.annotation.JsonSerializable;
import com.jdbc.annotation.JsonElement;
import com.jdbc.annotation.Init;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@JsonSerializable
public class User {
    @JsonElement
    private long id;
    @JsonElement
    private String firstName;
    @JsonElement
    private String lastName;
    @JsonElement
    private String email;
    private String password;
    private long roleId;

    @Init
    private void initNames() {

    }
}
