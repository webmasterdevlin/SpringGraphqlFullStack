package com.example.graphqldemo.types;

import com.example.graphqldemo.enums.Status;

public record ProjectInput(
        Integer clientId,
        String name,
        String description,
        Status status
) {}
