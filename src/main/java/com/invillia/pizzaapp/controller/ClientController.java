package com.invillia.pizzaapp.controller;

import com.invillia.pizzaapp.model.request.ClientRequest;
import com.invillia.pizzaapp.model.response.ClientResponse;
import com.invillia.pizzaapp.service.ClientService;
import org.bson.types.ObjectId;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clients")
@CrossOrigin("*")
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<ClientResponse> findAll(){
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public ClientResponse findById(@PathVariable String id){
        return clientService.findById(id);
    }

    @PostMapping
    public HttpEntity<?> insert(@Valid @RequestBody ClientRequest clientRequest){
        ObjectId id = clientService.insert(clientRequest);
        URI location= ServletUriComponentsBuilder.fromCurrentContextPath().path("/clients/{id}").build(id);

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable String id, @Valid @RequestBody ClientRequest clientRequest){
        clientService.update(id,clientRequest);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable String id){
        clientService.delete(id);

        return ResponseEntity.noContent().build();
    }


}
