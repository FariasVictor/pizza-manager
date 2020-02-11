package com.invillia.pizzaapp.repository;

import com.invillia.pizzaapp.model.Demand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandRepository extends JpaRepository<Demand,Long> {
}
