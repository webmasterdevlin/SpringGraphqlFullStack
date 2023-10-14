import { gql } from "@apollo/client"; // Relay or Apollo/Client

const ADD_CLIENT = gql`
  mutation createClient($clientInput: ClientInput) {
    newClient(input: $clientInput) {
      id
      name
      email
      phone
    }
  }
`;

const DELETE_CLIENT = gql`
  mutation removeClient($clientId: ID!) {
    deleteClient(id: $clientId)
  }
`;

export { ADD_CLIENT, DELETE_CLIENT };
