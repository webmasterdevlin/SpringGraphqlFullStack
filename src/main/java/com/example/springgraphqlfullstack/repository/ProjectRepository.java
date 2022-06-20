package com.example.springgraphqlfullstack.repository;

import com.example.springgraphqlfullstack.model.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Integer> {

}
