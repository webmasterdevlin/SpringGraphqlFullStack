package com.example.graphqldemo.types;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientInput {
    private String name;
    private String email;
    private String phone;
}
