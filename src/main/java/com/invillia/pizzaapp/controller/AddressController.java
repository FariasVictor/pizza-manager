package com.invillia.pizzaapp.controller;

import com.fasterxml.jackson.databind.deser.CreatorProperty;
import com.invillia.pizzaapp.model.Address;
import com.invillia.pizzaapp.model.request.AddressRequest;
import com.invillia.pizzaapp.model.request.UpdateAddressRequest;
import com.invillia.pizzaapp.model.response.AddressResponse;
import com.invillia.pizzaapp.service.AddressService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    private AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public HttpEntity<?> insert(@Valid @RequestBody AddressRequest addressRequest){
        Long id = addressService.insert(addressRequest);
        final URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").build(id);

        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public List<AddressResponse> findAll(){
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public AddressResponse findById(@PathVariable Long id){
        return addressService.findById(id);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Long id, @Valid @RequestBody UpdateAddressRequest updateAddressRequest){
        addressService.update(id, updateAddressRequest);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Long id){
        addressService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
