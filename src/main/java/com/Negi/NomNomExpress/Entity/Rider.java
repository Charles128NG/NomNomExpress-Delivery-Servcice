package com.Negi.NomNomExpress.Entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="rider")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rider extends UserEntity{
	@Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = true)
    private String currentLocation;

    @Column(nullable = false)
    private String isAvailable = "Y";

    @Column(nullable = true)
    private String location;
}
