package com.invillia.pizzaapp.mapper;

import com.invillia.pizzaapp.model.Client;
import com.invillia.pizzaapp.model.request.ClientRequest;
import com.invillia.pizzaapp.model.response.ClientResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientMapper {

    public List<ClientResponse> clientToClientResponse(List<Client> clients){
        List<ClientResponse> clientResponses = new ArrayList<>();

        clients.forEach(
                client->clientResponses.add(this.clientToClientResponse(client))
        );

        return clientResponses;
    }

    public ClientResponse clientToClientResponse(Client client){
        ClientResponse clientResponse = new ClientResponse();
        clientResponse.setId(client.getId().toString());
        clientResponse.setName(client.getName());
        clientResponse.setPhone(client.getPhone());

        return clientResponse;
    }

    public Client clientRequestToClient(ClientRequest clientRequest){
        Client client= new Client();

        client.setName(clientRequest.getName());
        client.setPhone(clientRequest.getPhone());

        return client;
    }

    public void updateClientByClientRequest(Client client, ClientRequest clientRequest){
        client.setPhone(clientRequest.getPhone());
        client.setName(clientRequest.getName());
    }
}
