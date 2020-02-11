package com.invillia.pizzaapp.service;

import com.invillia.pizzaapp.mapper.ClientMapper;
import com.invillia.pizzaapp.model.Client;
import com.invillia.pizzaapp.model.request.ClientRequest;
import com.invillia.pizzaapp.model.response.ClientResponse;
import com.invillia.pizzaapp.repository.ClientRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClientService {

    private ClientRepository clientRepository;
    private ClientMapper clientMapper;

    public ClientService(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Transactional
    public Long insert(ClientRequest clientRequest) {
        Client client = clientMapper.clientRequestToClient(clientRequest);
        client = clientRepository.save(client);
        return client.getId();
    }

    public List<ClientResponse> findAll() {
        return clientMapper.clientToClientResponse(clientRepository.findAll());
    }

    public ClientResponse findById(Long id) {
        return clientMapper.clientToClientResponse(
                clientRepository.findById(id).orElseThrow(EntityNotFoundException::new)
        );
    }

    @Transactional
    public void update(Long id, ClientRequest clientRequest){
        Client client = clientRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        clientMapper.updateClientByClientRequest(client,clientRequest);
        clientRepository.save(client);
    }

    @Transactional
    public void delete(Long id){
        clientRepository.delete(
                clientRepository.findById(id).orElseThrow(EntityNotFoundException::new)
        );
    }
}
