package com.invillia.pizzaapp.model.request;

import com.invillia.pizzaapp.model.Pizza;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemandRequest {

    @NotEmpty
    private List<Pizza> pizzas;
}
