package com.invillia.pizzaapp.model.response;

import com.invillia.pizzaapp.model.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemandResponse {
    private Long id;
    private BigDecimal debt;
    private Client client;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
