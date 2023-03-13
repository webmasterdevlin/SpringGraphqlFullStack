package com.example.springgraphqlfullstack;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.graphql.test.tester.GraphQlTester;

@GraphQlTest(ProjectController.class)
public class ProjectControllerTests {
    @Autowired
    private GraphQlTester graphQlTester;

    @Test
    void shouldGetFirstProject() {
        this.graphQlTester
                .document("projectDetails")
                .variable("id", "1")
                .execute()
                .path("project")
                .matchesJson("""
                    {
                        "id": "1",
                        "name": "eCommerce Website",
                        "description": "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu.",
                        "status": "pending",
                        "client": {
                          "id": "1",
                          "name": "Tony Stark",
                          "email": "ironman@gmail.com",
                          "phone": "343-567-4333"
                        }
                    }
                """);
    }
}
