package com.invillia.pizzaapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    private ObjectId id;

    private String name;

    private List<String> phone;

    private List<Address> addresses;

    private List<Demand> demands;

}
