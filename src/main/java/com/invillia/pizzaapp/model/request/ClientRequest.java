package com.invillia.pizzaapp.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequest {

    @NotEmpty
    private String name;

    @NotEmpty
    private  List<@Length(min=11, max=16, message = "O telefone deve ter de 11 a 16 caracteres") String> phone;
}
