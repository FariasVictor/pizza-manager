package com.invillia.pizzaapp.service;

import com.invillia.pizzaapp.exception.InvalidValueException;
import com.invillia.pizzaapp.mapper.DemandMapper;
import com.invillia.pizzaapp.model.Demand;
import com.invillia.pizzaapp.model.Pizza;
import com.invillia.pizzaapp.model.PizzasToBeMade;
import com.invillia.pizzaapp.model.request.DemandRequest;
import com.invillia.pizzaapp.model.response.DemandResponse;
import com.invillia.pizzaapp.repository.ClientRepository;
import com.invillia.pizzaapp.repository.DemandRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
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
        initialDebtCalculator(demand);
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
        demand.setDebt(calculateTotalDebt(demandRequest.getPizzas().size(), demand.getPizzas().size(), demand.getDebt()));
        demandMapper.updateDemandByDemandRequest(demand, demandRequest);
        demandRepository.save(demand);
    }

    public PizzasToBeMade pizzasToBeMade() {
        int calabresa = 0;
        int traditional=0;
        List<Demand> totalToBeMade = demandRepository.findByMade(false);
        for (Demand demand : totalToBeMade) {
            for (Pizza pizza : demand.getPizzas()) {
                if (pizza.getFlavor().toString().equals("CALABRESA")){
                    calabresa++;
                }else{
                    traditional++;
                }
            }
        }
        return new PizzasToBeMade(calabresa,traditional);
    }

    public BigDecimal calculateTotalDebt(int newPizzaCount, int oldPizzaCount, BigDecimal oldDebt) {
        BigDecimal debt;
        debt = oldDebt.add(BigDecimal.valueOf((newPizzaCount - oldPizzaCount) * 20));
        return debt;
    }

    @Transactional
    public void payment(String id, BigDecimal value) {
        Demand demand = demandRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        if (value.compareTo(demand.getDebt()) > 0) {
            throw new InvalidValueException();
        }
        demand.setDebt(demand.getDebt().subtract(value));
        demandRepository.save(demand);
    }

    public void initialDebtCalculator(Demand demand) {
        demand.setDebt(BigDecimal.valueOf(demand.getPizzas().size() * 20));
    }
}
