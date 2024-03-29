package com.example.graphqldemo;

import com.example.graphqldemo.model.Client;
import com.example.graphqldemo.queryresolvers.ClientMutation;
import com.example.graphqldemo.repository.ClientRepository;
import com.example.graphqldemo.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.graphql.test.tester.GraphQlTester;

@GraphQlTest(ClientMutation.class)
public class QueryMutationTests {
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    private GraphQlTester graphQlTester;

    @Test
    void shouldBlah() {
        var value = new Client();
        value.setName("Tony Stark");
        value.setEmail("ironman@gmail.com");
        value.setPhone("343-567-4333");

        this.graphQlTester
                .document("createClient")
                .variable("clientInput","value")
                .execute()
                .path("newClient")
                .matchesJson("""
                        "id":"1",
                        "name":"Tony Stark",
                        "email":"ironman@gmail.com",
                        "phone":"343-567-4333"
                        """);
    }
}
