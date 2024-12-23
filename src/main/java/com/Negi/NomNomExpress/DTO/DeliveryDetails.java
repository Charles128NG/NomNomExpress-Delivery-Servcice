package com.Negi.NomNomExpress.DTO;

import java.time.LocalDateTime;

import com.Negi.NomNomExpress.Entity.Delivery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryDetails {
	
	private Long deliveryId;

    private Long orderId;

    private Long restaurantId;

    private Long userId;

    private Long riderId;

    private String status; // Example: ASSIGNED, PICKED_UP, EN_ROUTE, DELIVERED

    private String deliveryAddress;

    private LocalDateTime assignedAt;

    private LocalDateTime pickedUpAt;
    
    private LocalDateTime deliveredAt;
	
    public DeliveryDetails(Delivery delivery) {
		this.deliveryId = delivery.getDeliveryId();
		this.orderId = delivery.getOrderId();
		this.restaurantId = delivery.getRestaurantId();
		this.userId = delivery.getUserId();
		this.riderId = delivery.getRiderId();
		this.status = delivery.getStatus();
		this.deliveryAddress = delivery.getDeliveryAddress();
		this.assignedAt = delivery.getAssignedAt();
		this.pickedUpAt = delivery.getPickedUpAt();
		this.deliveredAt = delivery.getDeliveredAt();
	}
}
