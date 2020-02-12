package com.invillia.pizzaapp.service;

import com.invillia.pizzaapp.exception.InvalidFlavorException;
import com.invillia.pizzaapp.enums.Flavor;
import com.invillia.pizzaapp.mapper.PizzaMapper;
import com.invillia.pizzaapp.model.Demand;
import com.invillia.pizzaapp.model.Pizza;
import com.invillia.pizzaapp.model.request.PizzaRequest;
import com.invillia.pizzaapp.model.request.UpdatePizzaRequest;
import com.invillia.pizzaapp.model.response.PizzaResponse;
import com.invillia.pizzaapp.repository.DemandRepository;
import com.invillia.pizzaapp.repository.PizzaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class PizzaService {

    private PizzaRepository pizzaRepository;
    private PizzaMapper pizzaMapper;
    private DemandRepository demandRepository;

    public PizzaService(PizzaRepository pizzaRepository, PizzaMapper pizzaMapper, DemandRepository demandRepository) {
        this.pizzaRepository = pizzaRepository;
        this.pizzaMapper = pizzaMapper;
        this.demandRepository = demandRepository;
    }

    @Transactional
    public Long insert(PizzaRequest pizzaRequest) {
        if (!validateFlavorEnum(pizzaRequest.getFlavor())) {
            throw new InvalidFlavorException();
        }
        Demand demand = demandRepository.findById(pizzaRequest.getDemandId()).orElseThrow(EntityNotFoundException::new);

        Pizza pizza = new Pizza();
        pizza.setFlavor(Flavor.valueOf(pizzaRequest.getFlavor()));
        pizza.setDemand(demand);

        return pizzaRepository.save(pizza).getId();
    }

    public PizzaResponse findById(Long id) {
        Pizza pizza = pizzaRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return pizzaMapper.pizzaToPizzaResponse(pizza);
    }

    public List<PizzaResponse> findAll() {
        return pizzaMapper.pizzaToPizzaResponse(pizzaRepository.findAll());
    }

    @Transactional
    public void update(Long id, UpdatePizzaRequest updatePizzaRequest) {
        Pizza pizza = pizzaRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        if (!validateFlavorEnum(updatePizzaRequest.getFlavor())) {
            throw new InvalidFlavorException();
        }
        pizza.setFlavor(Flavor.valueOf(updatePizzaRequest.getFlavor()));

        pizzaRepository.save(pizza);
    }

    @Transactional
    public void delete(Long id){
        pizzaRepository.delete(
                pizzaRepository.findById(id).orElseThrow(EntityNotFoundException::new)
        );
    }

    public boolean validateFlavorEnum(String flavor) {
        for (Flavor fl : Flavor.values()) {
            if (fl.name().equals(flavor)) {
                return true;
            }
        }
        return false;
    }

}
