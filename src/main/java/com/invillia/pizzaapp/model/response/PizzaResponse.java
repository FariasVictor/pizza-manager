package com.invillia.pizzaapp.model.response;

import com.invillia.pizzaapp.model.Demand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PizzaResponse {
    private Long id;
    private String flavor;
    private Demand demand;
}
