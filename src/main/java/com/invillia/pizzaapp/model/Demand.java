package com.invillia.pizzaapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Demand {

    @Id
    private ObjectId id;

    private Boolean made =false;

    private BigDecimal debt= BigDecimal.valueOf(0);

    private List<Pizza> pizzas;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
