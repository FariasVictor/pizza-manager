package com.invillia.pizzaapp.controller;

import com.invillia.pizzaapp.model.request.DemandRequest;
import com.invillia.pizzaapp.model.response.DemandResponse;
import com.invillia.pizzaapp.service.DemandService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/demands")
public class DemandController {

    private DemandService demandService;

    public DemandController(DemandService demandService) {
        this.demandService = demandService;
    }

    @PostMapping
    public HttpEntity<?> insert(@RequestBody @Valid DemandRequest demandRequest){
        Long id = demandService.insert(demandRequest);
        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path((("/{id}"))).build(id);

        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public List<DemandResponse> findAll(){
       return demandService.findAll();
    }

    @GetMapping("{id}")
    public DemandResponse findById(@PathVariable Long id){
        return demandService.findById(id);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> updateClient(@PathVariable Long id,@Valid @RequestBody DemandRequest demandRequest){
        demandService.updateClient(id, demandRequest);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Long id){
        demandService.delete(id);

        return ResponseEntity.noContent().build();
    }

}
