package com.Negi.NomNomExpress.DTO;

import javax.persistence.Column;

import com.Negi.NomNomExpress.Entity.Rider;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RiderDetailsDTO {
    private String name;
   
    private Long id;
    
	private String phoneNumber;
    
    private String currentLocation;

    private String isAvailable = "Y";

	
    public RiderDetailsDTO(Rider rider) {
		this.name = rider.getUserName();
		this.id = rider.getUserId();
		this.phoneNumber = rider.getPhoneNumber();
		this.currentLocation = rider.getCurrentLocation();
		this.isAvailable = rider.getIsAvailable();
	}

}
