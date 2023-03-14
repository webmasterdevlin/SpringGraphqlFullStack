import { gql } from "@apollo/client";

const ADD_PROJECT = gql`
  mutation createProject($projectInput: ProjectInput) {
    newProject(input: $projectInput) {
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
`;

const DELETE_PROJECT = gql`
  mutation removeProject($projectId: ID!) {
    deleteProject(id: $projectId)
  }
`;

export { ADD_PROJECT, DELETE_PROJECT };
