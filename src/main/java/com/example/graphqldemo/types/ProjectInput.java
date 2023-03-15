package com.example.graphqldemo.types;

import com.example.graphqldemo.enums.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectInput {
    private Integer clientId;
    private String name;
    private String description;
    private Status status;
}
