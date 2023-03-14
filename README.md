## Fullstack GraphQL using Spring Boot and Reactjs

### Spring Boot GraphQL Endpoint
- localhost:8080/graphql

### React App
- localhost:3000

### GraphiQL Client
- http://localhost:8080/graphiql

### Sample Mutations
```txt
mutation createClient($clientInput: ClientInput) {
  newClient(input:$clientInput) {
    id
    name
    email
    phone
  }
}

mutation createProject($projectInput: ProjectInput) {
  newProject(input:$projectInput) {
    id
    name
    description
    status
    client {
      id
      name
      email
      phone
    }
  }
}
mutation removeClient($clientId:ID!) {
  deleteClient(id:$clientId)
}
mutation removeProject($projectId:ID!) {
  deleteProject(id:$projectId)
}
```
### Sample Variables for Mutaions
```txt
{
  "projectInput":{
    "name": "eCommerce Website",
    "description": "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu.",
    "status": "pending",
    "clientId": "1"
  },
  "clientInput": {
    "name": "Tony Stark",
    "email": "ironman@gmail.com",
    "phone": "343-567-4333"
  },
  "clientId":"1",
  "projectId":"1"
}
```

### Sample Queries
```txt
query fetchProjects {
   projects {
    id
    projectName:name
    client {
      id
      clientName: name 
    }
  }
}
```
