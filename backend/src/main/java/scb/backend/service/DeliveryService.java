package scb.backend.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import scb.backend.dto.DeliveryDto;
import scb.backend.entity.Delivery;
import scb.backend.entity.Status;
import scb.backend.exception.DeliveryNotFoundException;
import scb.backend.repository.DeliveryRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DeliveryService {

    private final DeliveryRepository repository;
    private final ModelMapper mapper;

    public DeliveryService(DeliveryRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public List<DeliveryDto> findAll(){
        List<Delivery> deliveries = repository.findAll();
        return deliveries.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public DeliveryDto save(DeliveryDto dto, String name){
        Delivery delivery = mapToEntity(dto);
        delivery.setCreator(name);
        Delivery newDelivery =  repository.save(delivery);
        return mapToDTO(newDelivery);
    }

    public DeliveryDto findById(long id){
        Delivery delivery = repository.findById(id).orElseThrow(() ->
                new DeliveryNotFoundException(id));
        return mapToDTO(delivery);
    }

    public DeliveryDto update(DeliveryDto dto, long id){
        Delivery delivery = repository.findById(id).orElseThrow(() ->
                new DeliveryNotFoundException(id));

        //todo change
        delivery.getOrder().setPrice(dto.getOrderPrice());
        delivery.getOrder().setProduct(dto.getOrderProduct());
        delivery.setStatus(Status.valueOf(dto.getStatus()));
        delivery.getClient().setName(dto.getClientName());
        delivery.getClient().setAddress(dto.getClientAddress());
        delivery.getClient().setNumber(dto.getClientNumber());

        Delivery newDelivery = repository.save(delivery);
        return mapToDTO(newDelivery);
    }

    private DeliveryDto mapToDTO(Delivery delivery){
        return mapper.map(delivery, DeliveryDto.class);
    }

    private Delivery mapToEntity(DeliveryDto dto){
        return  mapper.map(dto, Delivery.class);
    }

}
