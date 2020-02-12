package com.invillia.pizzaapp.service;

import com.invillia.pizzaapp.mapper.DemandMapper;
import com.invillia.pizzaapp.model.Client;
import com.invillia.pizzaapp.model.Demand;
import com.invillia.pizzaapp.model.request.DemandRequest;
import com.invillia.pizzaapp.model.response.DemandResponse;
import com.invillia.pizzaapp.repository.ClientRepository;
import com.invillia.pizzaapp.repository.DemandRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class DemandService {

    private DemandRepository demandRepository;
    private DemandMapper demandMapper;
    private ClientRepository clientRepository;

    public DemandService(DemandRepository demandRepository, DemandMapper demandMapper, ClientRepository clientRepository) {
        this.demandRepository = demandRepository;
        this.demandMapper = demandMapper;
        this.clientRepository = clientRepository;
    }

    @Transactional
    public Long insert(DemandRequest demandRequest) {
        Client client= clientRepository.findById(demandRequest.getClientId()).orElseThrow(EntityNotFoundException::new);
        Demand demand = new Demand();
        demand.setClient(client);
        return demandRepository.save(demand).getId();
    }

    public List<DemandResponse> findAll() {
        return demandMapper.demandToDemandResponse(demandRepository.findAll());
    }

    public DemandResponse findById(Long id) {
        Demand demand = demandRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return demandMapper.demandToDemandResponse(demand);
    }

    @Transactional
    public void updateClient(Long id, DemandRequest demandRequest) {
        Demand demand = demandRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        Client client= clientRepository.findById(demandRequest.getClientId()).orElseThrow(EntityNotFoundException::new);
        demand.setClient(client);
        demandRepository.save(demand);
    }

    @Transactional
    public void delete(Long id) {
        demandRepository.delete(
                demandRepository.findById(id).orElseThrow(EntityNotFoundException::new)
        );
    }
}
