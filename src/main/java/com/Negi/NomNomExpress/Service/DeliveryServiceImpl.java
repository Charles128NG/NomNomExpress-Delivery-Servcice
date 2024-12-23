package com.Negi.NomNomExpress.Service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.Negi.NomNomExpress.DTO.GetDeliveryDetailsRequestDTO;
import com.Negi.NomNomExpress.DTO.GetRiderDetailsDTO;
import com.Negi.NomNomExpress.DTO.MarkFoodDeliveredDTO;
import com.Negi.NomNomExpress.DTO.RiderDetailsDTO;
import com.Negi.NomNomExpress.Entity.Delivery;
import com.Negi.NomNomExpress.Entity.Rider;
import com.Negi.NomNomExpress.Entity.UserEntity;
import com.Negi.NomNomExpress.Exception.RESTException;
import com.Negi.NomNomExpress.Repository.*;
import com.Negi.NomNomExpress.kafka.KafkaProducerService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DeliveryServiceImpl implements DeliveryService {
	
	@Autowired
	private RiderRepository riderRepo;
	
	@Autowired
	private DeliveryRepository deliveryRepo;
	
	@Autowired
	private KafkaProducerService kafkaService;
	
	@Autowired UserRepository userRepo;
	
	ObjectMapper objectMapper = new ObjectMapper();
	
	@Override
	public Rider getRiderDetails(@Valid GetRiderDetailsDTO getRiderDetailsDTO) throws RESTException{
		try {
			Optional<Rider> riderOptional = riderRepo.findById(getRiderDetailsDTO.getId());
			if(!riderOptional.isPresent()) {
				throw new RESTException("Invalid Rider ID", HttpStatus.BAD_REQUEST);
			}else {
				return riderOptional.get();
			}
		}catch(RESTException e) {
			throw e;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new RESTException(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	

	@Override
	public String markFoodDelivered(@Valid MarkFoodDeliveredDTO markFoodDelivered) throws RESTException{
		try {
			
			kafkaService.sendMessage2(objectMapper.writeValueAsString(markFoodDelivered));
			return "food marked delivered";
		}catch(RESTException e) {
			throw e;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new RESTException(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public Delivery getDeliveryDetails(@Valid GetDeliveryDetailsRequestDTO request) throws RESTException{
		try {
			Optional<Delivery> deliveryOptional = deliveryRepo.findById(request.getDeliveryId());
			if(!deliveryOptional.isPresent()) {
				throw new RESTException("Invalid Delivery ID", HttpStatus.BAD_REQUEST);
			}else {
				return deliveryOptional.get();
			}
		}catch(RESTException e) {
			throw e;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new RESTException(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}



	@Override
	public Rider addRider(@Valid RiderDetailsDTO request) throws RESTException{
		try {
			Optional<UserEntity> userOptional = userRepo.findById(request.getId());
			if(userOptional.isEmpty()) {
				throw new RESTException("Invalid User Id", HttpStatus.BAD_REQUEST);
			}else {
				Rider rider = new Rider();
				rider.setUserId(request.getId());
				rider.setIsAvailable("Y");
				rider.setCurrentLocation(request.getCurrentLocation());
				rider.setPhoneNumber(request.getPhoneNumber());
				return riderRepo.save(rider);
			}
		}catch(RESTException e) {
			throw e;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new RESTException(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
