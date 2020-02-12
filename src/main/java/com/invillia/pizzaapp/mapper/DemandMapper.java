package com.invillia.pizzaapp.mapper;

import com.invillia.pizzaapp.model.Demand;
import com.invillia.pizzaapp.model.request.DemandRequest;
import com.invillia.pizzaapp.model.response.DemandResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DemandMapper {

//    public Demand demandRequestToDemand(DemandRequest demandRequest){
//        Demand demand = new Demand();
//        demand.setClient(demandRequest.getClient());
//        return demand;
//    }

    public List<DemandResponse> demandToDemandResponse(List<Demand> demands){
        List<DemandResponse> demandResponses= new ArrayList<>();
        demands.forEach(demand -> demandResponses.add(this.demandToDemandResponse(demand)));
        return demandResponses;
    }

    public DemandResponse demandToDemandResponse(Demand demand){
        DemandResponse demandResponse= new DemandResponse();
        demandResponse.setClient(demand.getClient());
        demandResponse.setId(demand.getId());
        demandResponse.setDebt(demand.getDebt());
        demandResponse.setCreatedAt(demand.getCreatedAt());
        demandResponse.setUpdatedAt(demand.getUpdatedAt());
        return demandResponse;
    }

//    public void updateDemandByDemandRequest(Demand demand, DemandRequest demandRequest){
//        demand.setClient(demandRequest.getClientId());
//    }
}
