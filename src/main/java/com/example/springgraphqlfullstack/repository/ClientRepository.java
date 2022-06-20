package com.example.springgraphqlfullstack.repository;

import com.example.springgraphqlfullstack.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {

}
