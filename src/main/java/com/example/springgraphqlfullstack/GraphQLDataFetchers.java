package com.example.springgraphqlfullstack;

import com.google.common.collect.ImmutableMap;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class GraphQLDataFetchers {

    private static final List<Map<String, String>> projects = Arrays.asList(
            ImmutableMap.of(
                    "id","1",
                    "clientId","1",
                    "name", "eCommerce Website",
                    "description",
                    "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu.",
                    "status", "pending"),
            ImmutableMap.of(
                    "id", "2",
                    "clientId", "2",
                    "name","Dating App",
                    "description","Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu.",
                    "status","pending"),
            ImmutableMap.of(
                    "id", "3",
                    "clientId","3",
                    "name","SEO Project",
                    "description","Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu.",
                    "status","pending"),
            ImmutableMap.of(
                    "id","4",
                    "clientId","4",
                    "name","Design Prototype",
                    "description",
                    "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu.",
                    "status","completed"),
            ImmutableMap.of(
                    "id","5",
                    "clientId","5",
                    "name","Auction Website",
                    "description","Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu.",
                    "status","ongoing")
);

    private static final List<Map<String, String>> clients = Arrays.asList(
            ImmutableMap.of(
                    "id","1",
                    "name","Tony Stark",
                    "email","ironman@gmail.com",
                    "phone","343-567-4333"),
            ImmutableMap.of(
                    "id","2",
                    "name","Natasha Romanova",
                    "email","blackwidow@gmail.com",
                    "phone","223-567-3322"),
            ImmutableMap.of(
                    "id","3",
                    "name","Thor Odinson",
                    "email","thor@gmail.com",
                    "phone","324-331-4333"),
            ImmutableMap.of(
                    "id","4",
                    "name","Steve Rogers",
                    "email","steve@gmail.com",
                    "phone","344-562-6787"),
            ImmutableMap.of(
                    "id","5",
                    "name","Bruce Banner",
                    "email","bruce@gmail.com",
                    "phone","321-468-8887")
);

    public DataFetcher getProjectsDataFetcher() {
        return dataFetchingEnvironment -> projects.stream();
    }

    public DataFetcher getProjectByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            String projectId = dataFetchingEnvironment.getArgument("id");
            return projects
                    .stream()
                    .filter(project -> project.get("id").equals(projectId))
                    .findFirst()
                    .orElse(null);
        };
    }

    public DataFetcher getClientsDataFetcher() {
        return dataFetchingEnvironment -> clients.stream();
    }

    public DataFetcher getClientDataFetcher() {
        return dataFetchingEnvironment -> {
            Map<String, String> project = dataFetchingEnvironment.getSource();
            String clientId = project.get("clientId");
            return clients
                    .stream()
                    .filter(client -> client.get("id").equals(clientId))
                    .findFirst()
                    .orElse(null);
        };
    }
}
