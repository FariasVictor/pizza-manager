package com.invillia.pizzaapp.controller;

import com.invillia.pizzaapp.model.request.PizzaRequest;
import com.invillia.pizzaapp.model.request.UpdatePizzaRequest;
import com.invillia.pizzaapp.model.response.PizzaResponse;
import com.invillia.pizzaapp.service.PizzaService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {

    private PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public List<PizzaResponse> findAll(){
        return pizzaService.findAll();
    }

    @GetMapping("/{id}")
    public PizzaResponse findAll(@PathVariable Long id){
        return pizzaService.findById(id);
    }

    @PostMapping
    public HttpEntity<?> insert(@Valid @RequestBody PizzaRequest pizzaRequest){
        Long id = pizzaService.insert(pizzaRequest);
        final URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("{id}").build(id);

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Long id, @Valid @RequestBody UpdatePizzaRequest updatePizzaRequest){
        pizzaService.update(id,updatePizzaRequest);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Long id){
        pizzaService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
