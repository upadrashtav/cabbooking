package com.example.cabbooking.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cabbooking.model.Cabbookings;
import com.example.cabbooking.service.CabBookingService;

@RestController
@RequestMapping("/api/bookcab")
public class CabBookingsController {
	
	
	@Autowired
	private CabBookingService cabBookingService;

	public CabBookingsController(CabBookingService cabBookingService) {
		super();
		this.cabBookingService = cabBookingService;
	}
	
	//REST API to add bookings
	
	@PostMapping(
	        value = "/addbooking",
	        consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, // Adjust to the form data media type
	        produces = MediaType.APPLICATION_JSON_VALUE
	    )
	
	public ResponseEntity<Cabbookings> addCabBooking(@RequestParam Map<String, String> formData) {	
		
		//Convert fare value from String to Double
		
		Double fare = null;
		
		try {
			fare = Double.parseDouble(formData.get("fare"));
		} catch (NumberFormatException e) {
			fare = 0.0;
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
		Cabbookings cabBookings = Cabbookings.builder()
				.fromLocation(formData.get("fromLocationSelect"))
				.toLocation(formData.get("toLocationSelect"))
				.userName(formData.get("username"))
				.userPhone(formData.get("userphone"))
				.userEmail(formData.get("useremail"))
				.pickupDate(formData.get("pickupdate"))
				.pickupTime(formData.get("pickuptime"))
				.typeOfCab(formData.get("typeOfCab"))
				.build();	
		
		cabBookings.setFare(fare);
		
		//Save the Cabbookings object and return it
		Cabbookings savedBooking = cabBookingService.addCabBooking(cabBookings);
		return new ResponseEntity<>(savedBooking,HttpStatus.CREATED);
	}
	
}
