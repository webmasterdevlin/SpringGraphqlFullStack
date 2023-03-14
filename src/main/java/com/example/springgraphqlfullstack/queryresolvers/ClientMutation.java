package com.example.springgraphqlfullstack.queryresolvers;

import com.example.springgraphqlfullstack.model.Client;
import com.example.springgraphqlfullstack.repository.ClientRepository;
import com.example.springgraphqlfullstack.repository.ProjectRepository;
import com.example.springgraphqlfullstack.types.ClientInput;
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
        client.setName(input.getName());
        client.setEmail(input.getEmail());
        client.setPhone(input.getPhone());

        return clientRepository.save(client);
    }

    @MutationMapping
    public Integer deleteClient(@Argument Integer id) {
        clientRepository.deleteById(id);

        return id;
    }
}
