package com.invillia.pizzaapp.mapper;

import com.invillia.pizzaapp.model.Address;
import com.invillia.pizzaapp.model.request.AddressRequest;
import com.invillia.pizzaapp.model.request.UpdateAddressRequest;
import com.invillia.pizzaapp.model.response.AddressResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddressMapper {

    public Address addressRequestToAddress(AddressRequest addressRequest){
        Address address = new Address();

        address.setCity(addressRequest.getCity());
        address.setDistrict(addressRequest.getDistrict());
        address.setStreet(addressRequest.getStreet());
        address.setNumber(addressRequest.getNumber());
        address.setComplement(addressRequest.getComplement());

        return address;
    }

    public void updateAddressByAddressRequest(Address address, UpdateAddressRequest addressRequest){
        address.setCity(addressRequest.getCity());
        address.setDistrict(addressRequest.getDistrict());
        address.setStreet(addressRequest.getStreet());
        address.setNumber(addressRequest.getNumber());
        address.setComplement(addressRequest.getComplement());
    }

    public List<AddressResponse> addressToAddressResponse(List<Address> addresses){
        List<AddressResponse> addressResponses = new ArrayList<>();
        addresses.forEach(address -> addressResponses.add(this.addressToAddressResponse(address)));
        return addressResponses;
    }


    public AddressResponse addressToAddressResponse(Address address){
        AddressResponse addressResponse = new AddressResponse();
        addressResponse.setId(address.getId());
        addressResponse.setClient(address.getClient());
        addressResponse.setCity(address.getCity());
        addressResponse.setDistrict(address.getDistrict());
        addressResponse.setStreet(address.getStreet());
        addressResponse.setNumber(address.getNumber());
        addressResponse.setComplement(address.getComplement());
        return addressResponse;
    }
}
