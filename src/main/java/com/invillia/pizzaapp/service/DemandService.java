package com.invillia.pizzaapp.service;

import com.invillia.pizzaapp.exception.InvalidValueException;
import com.invillia.pizzaapp.mapper.DemandMapper;
import com.invillia.pizzaapp.model.Demand;
import com.invillia.pizzaapp.model.request.DemandRequest;
import com.invillia.pizzaapp.model.response.DemandResponse;
import com.invillia.pizzaapp.repository.ClientRepository;
import com.invillia.pizzaapp.repository.DemandRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
public class DemandService {

    private DemandRepository demandRepository;
    private DemandMapper demandMapper;

    public DemandService(DemandRepository demandRepository, DemandMapper demandMapper, ClientRepository clientRepository) {
        this.demandRepository = demandRepository;
        this.demandMapper = demandMapper;
    }

    @Transactional
    public ObjectId insert(DemandRequest demandRequest) {
        Demand demand = demandMapper.demandRequestToDemand(demandRequest);
        return demandRepository.save(demand).getId();
    }

    public List<DemandResponse> findAll() {
        return demandMapper.demandToDemandResponse(demandRepository.findAll());
    }

    public DemandResponse findById(String id) {
        Demand demand = demandRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return demandMapper.demandToDemandResponse(demand);
    }

    @Transactional
    public void delete(String id) {
        demandRepository.delete(
                demandRepository.findById(id).orElseThrow(EntityNotFoundException::new)
        );
    }

    @Transactional
    public void update(String id, DemandRequest demandRequest) {
        Demand demand = demandRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        demandMapper.updateDemandByDemandRequest(demand, demandRequest);
        demandRepository.save(demand);
    }
    }
}
