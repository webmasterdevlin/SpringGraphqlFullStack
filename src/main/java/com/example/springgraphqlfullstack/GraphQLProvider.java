package com.example.springgraphqlfullstack;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

@Component
public class GraphQLProvider {


    final
    GraphQLDataFetchers graphQLDataFetchers;

    private GraphQL graphQL;

    @Bean // exposed as a Spring Bean via the graphQL()
    public GraphQL graphQL() {
        return graphQL;
    }

    public GraphQLProvider(GraphQLDataFetchers graphQLDataFetchers) {
        this.graphQLDataFetchers = graphQLDataFetchers;
    }

   /* init method to create a GraphQL instance.
    Guava Resources to read the file from our classpath.*/
    @PostConstruct
    public void init() throws IOException {
        URL url = Resources.getResource("schema.graphqls");
        String sdl = Resources.toString(url, Charsets.UTF_8);
        GraphQLSchema graphQLSchema = buildSchema(sdl);
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    // creates the GraphQLSchema instance and wires in code to fetch data
    private GraphQLSchema buildSchema(String sdl) {
        // TypeDefinitionRegistry is the parsed version of our schema file.
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(sdl);
        RuntimeWiring runtimeWiring = buildWiring();
        // SchemaGenerator combines the TypeDefinitionRegistry with RuntimeWiring to actually make the GraphQLSchema.
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
    }

    // buildWiring uses the graphQLDataFetchers bean to actually register the data fetchers:
    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type(newTypeWiring("Query")
                        .dataFetcher("project", graphQLDataFetchers.getProjectByIdDataFetcher()))
                .type(newTypeWiring("Project")
                        .dataFetcher("client", graphQLDataFetchers.getClientDataFetcher()))
                .type(newTypeWiring("Query")
                        .dataFetcher("projects", graphQLDataFetchers.getProjectsDataFetcher()))
                .type(newTypeWiring("Query")
                        .dataFetcher("clients", graphQLDataFetchers.getClientsDataFetcher()))
                .build();
    }
}
