package com.example.springgraphqlfullstack;


import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ClientController {
    @QueryMapping
    public List<Client> clients() {
        return Client.getAll();
    }


}
