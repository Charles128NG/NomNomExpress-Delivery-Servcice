package com.Negi.NomNomExpress.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import com.Negi.NomNomExpress.Service.DeliveryService;
import com.Negi.NomNomExpress.DTO.*;
import com.Negi.NomNomExpress.Entity.*;
import com.Negi.NomNomExpress.Exception.RESTException;

@RestController
public class DeliveryController {
	
	@Autowired
	DeliveryService service;
	
	@PostMapping("/getRiderDetails")
	public ResponseEntity<?> getRiderDetails(@Valid @RequestBody GetRiderDetailsDTO getRiderDetailsDTO) throws RESTException{
		try {
			return new ResponseEntity<>(new RiderDetailsDTO((Rider) service.getRiderDetails(getRiderDetailsDTO)), HttpStatus.OK);
		}catch(RESTException e) {
			throw e;
		}
	}
	
	@PostMapping("/markFoodDelivered")
	public ResponseEntity<?> markFoodDelivered(@Valid @RequestBody MarkFoodDeliveredDTO markFoodDelivered) throws RESTException{
		try {
			return new ResponseEntity<>((service.markFoodDelivered(markFoodDelivered)), HttpStatus.OK);
		}catch(RESTException e) {
			throw e;
		}
	}
	
	@PostMapping("/getDeliveryDetails")
	public ResponseEntity<?> getDeliveryDetails(@Valid @RequestBody GetDeliveryDetailsRequestDTO request) throws RESTException{
		try {
			return new ResponseEntity<>(new DeliveryDetails((Delivery) service.getDeliveryDetails(request)), HttpStatus.OK);
		}catch(RESTException e) {
			throw e;
		}
	}
	@PostMapping("/addRiderDetails")
	public ResponseEntity<?> addRiderDetails(@Valid @RequestBody RiderDetailsDTO request) throws RESTException{
		try {
			return new ResponseEntity<>(new RiderDetailsDTO((Rider) service.addRider(request)), HttpStatus.OK);
		}catch(RESTException e) {
			throw e;
		}
	}
}
