package com.invillia.pizzaapp.model.response;

import com.invillia.pizzaapp.model.Pizza;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemandResponse {
    private String id;
    private BigDecimal debt;
    private List<Pizza> pizzas;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
