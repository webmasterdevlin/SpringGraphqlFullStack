package com.example.springgraphqlfullstack.queryresolvers;

import com.example.springgraphqlfullstack.model.Client;
import com.example.springgraphqlfullstack.repository.ClientRepository;
import com.example.springgraphqlfullstack.repository.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class ClientQuery {
    ProjectRepository projectRepository;
    ClientRepository clientRepository;

    @QueryMapping
    public Iterable<Client> clients() {
        return clientRepository.findAll();
    }

    @QueryMapping
    public Client client(@Argument Integer id) {
        return clientRepository.findById(id).get();
    }
}
