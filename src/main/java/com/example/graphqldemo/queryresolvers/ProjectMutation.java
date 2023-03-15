package com.example.graphqldemo.queryresolvers;

import com.example.graphqldemo.model.Project;
import com.example.graphqldemo.repository.ClientRepository;
import com.example.graphqldemo.repository.ProjectRepository;
import com.example.graphqldemo.types.ProjectInput;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class ProjectMutation {
    ProjectRepository projectRepository;
    ClientRepository clientRepository;

    @MutationMapping
    public Project newProject(@Argument ProjectInput input) {
        Project project = new Project();
        project.setName(input.getName());
        project.setDescription(input.getDescription());
        project.setStatus(input.getStatus());
        if (clientRepository.findById(input.getClientId()).isPresent())
            project.setClient(clientRepository.findById(input.getClientId()).get());

        return projectRepository.save(project);
    }

    @MutationMapping
    public Integer deleteProject(@Argument Integer id) {
        projectRepository.deleteById(id);

        return id;
    }
}
