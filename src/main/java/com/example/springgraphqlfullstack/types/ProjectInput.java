package com.example.springgraphqlfullstack.types;

import com.example.springgraphqlfullstack.enums.Status;
import com.example.springgraphqlfullstack.model.Client;
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
