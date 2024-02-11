package com.example.cabbooking.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Table(name="cabbookings")
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder

public class Cabbookings {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonProperty()
	private long id;
		
	@Column(name="username",nullable=false)
	@JsonProperty("username")
	private String userName;
		
//	@Column(name="userPhone")
	@Column (name="user_phone")
	@JsonProperty("userphone")
	private String userPhone;
		
//	@Column(name="userEmail")
	@Column(name="user_email")
	@JsonProperty("useremail")
	private String userEmail;
	
//	@Column(name="fromLocatioin")
	@Column(name="from_location")
	@JsonProperty("from")
	private String fromLocation;
	
//	@Column(name="toLocatioin")
	@Column(name="to_location")
	@JsonProperty("to")
	private String toLocation;
	
	@Column(name="pickupDate")
	@JsonProperty("pickupdate")
	private String pickupDate;
	
	@Column(name="pickupTime")
	@JsonProperty("pickuptime")
	private String pickupTime;
	
//	@Column(name="typeOfCab")
	@Column(name="type_of_cab")
	@JsonProperty("typeOfCab")
	private String typeOfCab;
	
	@Column(name="FARE")
	@JsonProperty("fare")
	private Double fare;
		
}
