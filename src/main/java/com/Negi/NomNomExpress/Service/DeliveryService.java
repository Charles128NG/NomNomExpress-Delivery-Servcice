package com.Negi.NomNomExpress.Service;

import javax.validation.Valid;

import com.Negi.NomNomExpress.DTO.GetDeliveryDetailsRequestDTO;
import com.Negi.NomNomExpress.DTO.GetRiderDetailsDTO;
import com.Negi.NomNomExpress.DTO.MarkFoodDeliveredDTO;
import com.Negi.NomNomExpress.DTO.RiderDetailsDTO;
import com.Negi.NomNomExpress.Entity.Delivery;
import com.Negi.NomNomExpress.Entity.Rider;

public interface DeliveryService {

	Rider getRiderDetails(@Valid GetRiderDetailsDTO getRiderDetailsDTO);

	String markFoodDelivered(@Valid MarkFoodDeliveredDTO markFoodDelivered);
	
	Delivery getDeliveryDetails(@Valid GetDeliveryDetailsRequestDTO request);

	Rider addRider(@Valid RiderDetailsDTO request);

}
