package com.invillia.pizzaapp.model;

import com.invillia.pizzaapp.enums.Flavor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pizza {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false)
    public Flavor flavor;

    @ManyToOne
    @JoinColumn(name="demand_id",nullable = false)
    public Demand demand;
}
