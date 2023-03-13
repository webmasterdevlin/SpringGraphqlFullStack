package com.example.springgraphqlfullstack;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProjectController {
    @QueryMapping
    public Project project(@Argument String id) {
        return Project.getById(id);
    }

    @QueryMapping
    public List<Project> projects() {
        return Project.getAll();
    }

    @SchemaMapping
    public Client client(Project project) {
        return Client.getById(project.clientId());
    }
}
