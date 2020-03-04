package com.invillia.pizzaapp.model.response;

import com.invillia.pizzaapp.model.Address;
import com.invillia.pizzaapp.model.Demand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientResponse {

    private String id;

    private String name;

    private List<String> phone;

    private List<Address> addresses;

    private List <Demand> demands;

}
