package com.invillia.pizzaapp.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PizzaRequest {

    @NotEmpty
    private String flavor;

    @NotNull
    @Min(1L)
    private Long demandId;
}
