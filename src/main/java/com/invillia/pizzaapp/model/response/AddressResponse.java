package com.invillia.pizzaapp.model.response;

import com.invillia.pizzaapp.model.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponse {

    private Long id;

    private String city;

    private String district;

    private String street;

    private String number;

    private String complement;

    private Client client;

}
