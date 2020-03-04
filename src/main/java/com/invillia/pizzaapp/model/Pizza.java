package com.invillia.pizzaapp.model;

import com.invillia.pizzaapp.enums.Flavor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pizza {
    private Flavor flavor;
}
