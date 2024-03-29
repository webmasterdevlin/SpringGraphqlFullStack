package com.example.graphqldemo.queryresolvers;

import com.example.graphqldemo.model.Project;
import com.example.graphqldemo.repository.ClientRepository;
import com.example.graphqldemo.repository.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class ProjectQuery {
    ProjectRepository projectRepository;
    ClientRepository clientRepository;

    @QueryMapping
    public Iterable<Project> projects() {
        return projectRepository.findAll();
    }

    @QueryMapping
    public Project project(@Argument Integer id) {
        return projectRepository.findById(id).get();
    }
}
