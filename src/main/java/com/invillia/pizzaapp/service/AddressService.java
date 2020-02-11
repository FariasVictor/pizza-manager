package com.invillia.pizzaapp.service;

import com.invillia.pizzaapp.mapper.AddressMapper;
import com.invillia.pizzaapp.model.Address;
import com.invillia.pizzaapp.model.Client;
import com.invillia.pizzaapp.model.request.AddressRequest;
import com.invillia.pizzaapp.model.request.UpdateAddressRequest;
import com.invillia.pizzaapp.model.response.AddressResponse;
import com.invillia.pizzaapp.repository.AddressRepository;
import com.invillia.pizzaapp.repository.ClientRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class AddressService {

    private AddressRepository addressRepository;
    private AddressMapper addressMapper;
    private ClientRepository clientRepository;

    public AddressService(AddressRepository addressRepository,
                          AddressMapper addressMapper,
                          ClientRepository clientRepository) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
        this.clientRepository = clientRepository;
    }

    @Transactional
    public Long insert(AddressRequest addressRequest) {

        Address address = addressMapper.addressRequestToAddress(addressRequest);
        Client client=clientRepository.findById(addressRequest.getClientId()).orElseThrow(EntityNotFoundException::new);
        address.setClient(client);
        address = addressRepository.save(address);
        return address.getId();
    }

    public List<AddressResponse> findAll() {
        return addressMapper.addressToAddressResponse(addressRepository.findAll());
    }

    public AddressResponse findById(Long id) {
        return addressMapper.addressToAddressResponse(
                addressRepository.findById(id).orElseThrow(EntityNotFoundException::new)
        );
    }

    @Transactional
    public void update(Long id, UpdateAddressRequest updateAddressRequest){
        Address address = addressRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        addressMapper.updateAddressByAddressRequest(address, updateAddressRequest);
    }

    @Transactional
    public void delete(Long id){
        addressRepository.delete(
                addressRepository.findById(id).orElseThrow(EntityNotFoundException::new)
        );
    }
}
