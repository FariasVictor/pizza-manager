package com.invillia.pizzaapp.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequest {

    @NotEmpty
    private String name;

    @NotEmpty
    @Length(min = 11, max=15)
    private String phone;
}
