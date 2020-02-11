package com.invillia.pizzaapp.mapper;

import com.invillia.pizzaapp.model.Pizza;
import com.invillia.pizzaapp.model.response.PizzaResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PizzaMapper {

    public PizzaResponse pizzaToPizzaResponse(Pizza pizza){
        PizzaResponse pizzaResponse = new PizzaResponse();

        pizzaResponse.setDemand(pizza.getDemand());
        pizzaResponse.setFlavor(pizza.getFlavor().toString());
        pizzaResponse.setId(pizza.getId());

        return pizzaResponse;
    }

    public List<PizzaResponse> pizzaToPizzaResponse(List<Pizza> pizzas){
        List<PizzaResponse> pizzaResponses = new ArrayList<>();

        pizzas.forEach(pizza -> pizzaResponses.add(this.pizzaToPizzaResponse(pizza)));

        return pizzaResponses;
    }

}
