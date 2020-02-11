package com.invillia.pizzaapp.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAddressRequest {
    @NotEmpty(message = "O campo cidade não pode estar vazio")
    private String city;

    @NotEmpty(message = "O campo bairro não pode estar vazio")
    private String district;

    @NotEmpty(message = "O campo rua não pode estar vazio")
    private String street;

    @NotEmpty(message = "O campo número não pode estar vazio")
    @Length(max=6,  message = "O número deve conter de 1 a 6 caracteres")
    private String number;

    private String complement;
}
