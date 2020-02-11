package com.invillia.pizzaapp.service;

import com.invillia.pizzaapp.mapper.DemandMapper;
import com.invillia.pizzaapp.model.Demand;
import com.invillia.pizzaapp.model.request.DemandRequest;
import com.invillia.pizzaapp.model.response.DemandResponse;
import com.invillia.pizzaapp.repository.DemandRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class DemandService {

    private DemandRepository demandRepository;
    private DemandMapper demandMapper;

    public DemandService(DemandRepository demandRepository, DemandMapper demandMapper) {
        this.demandRepository = demandRepository;
        this.demandMapper = demandMapper;
    }

    @Transactional
    public Long insert(DemandRequest demandRequest) {
        Demand demand = demandMapper.demandRequestToDemand(demandRequest);
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
        demandMapper.updateDemandByDemandRequest(demand, demandRequest);
        demandRepository.save(demand);
    }

    @Transactional
    public void delete(Long id) {
        demandRepository.delete(
                demandRepository.findById(id).orElseThrow(EntityNotFoundException::new)
        );
    }
}
