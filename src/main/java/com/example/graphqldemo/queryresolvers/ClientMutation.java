package com.example.graphqldemo.queryresolvers;

import com.example.graphqldemo.model.Client;
import com.example.graphqldemo.repository.ClientRepository;
import com.example.graphqldemo.repository.ProjectRepository;
import com.example.graphqldemo.types.ClientInput;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class ClientMutation {
    ProjectRepository projectRepository;
    ClientRepository clientRepository;

    @MutationMapping
    public Client newClient(@Argument ClientInput input) {
        Client client = new Client();
        client.setName(input.name());
        client.setEmail(input.email());
        client.setPhone(input.phone());

        return clientRepository.save(client);
    }

    @MutationMapping
    public Integer deleteClient(@Argument Integer id) {
        clientRepository.deleteById(id);

        return id;
    }
}
