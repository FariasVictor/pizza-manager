package com.invillia.pizzaapp.repository;

import com.invillia.pizzaapp.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza,Long> {
}
