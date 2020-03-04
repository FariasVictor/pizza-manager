package com.invillia.pizzaapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String city;

    private String district;

    private String street;

    private String number;

    private String complement;


}
