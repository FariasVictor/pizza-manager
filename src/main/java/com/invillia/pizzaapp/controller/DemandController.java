package com.invillia.pizzaapp.controller;

import com.invillia.pizzaapp.model.request.DemandRequest;
import com.invillia.pizzaapp.model.request.PaymentRequest;
import com.invillia.pizzaapp.model.response.DemandResponse;
import com.invillia.pizzaapp.service.DemandService;
import org.bson.types.ObjectId;
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
    public HttpEntity<?> insert(@RequestBody @Valid DemandRequest demandRequest) {
        ObjectId id = demandService.insert(demandRequest);
        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path((("/demands/{id}"))).build(id);

        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public List<DemandResponse> findAll() {
        return demandService.findAll();
    }

    @GetMapping("/{id}")
    public DemandResponse findById(@PathVariable String id) {
        return demandService.findById(id);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable String id, @Valid @RequestBody DemandRequest demandRequest) {
        demandService.update(id, demandRequest);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable String id) {
        demandService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
