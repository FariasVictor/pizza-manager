package com.invillia.pizzaapp.model.request;

import com.invillia.pizzaapp.model.Client;
import com.invillia.pizzaapp.model.Pizza;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemandRequest {

    @NotNull
    private Client client;

}
