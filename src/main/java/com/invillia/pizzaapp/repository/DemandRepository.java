package com.invillia.pizzaapp.repository;

import com.invillia.pizzaapp.model.Demand;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemandRepository extends MongoRepository<Demand, String> {
    List<Demand> findByMade(Boolean made);
}
