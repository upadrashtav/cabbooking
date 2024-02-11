package com.example.cabbooking.serviceimplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cabbooking.model.Cabbookings;
import com.example.cabbooking.repository.CabBookingsRepository;
import com.example.cabbooking.service.CabBookingService;

@Service
public class CabBookingServiceImplementation implements CabBookingService{

	@Autowired
	private CabBookingsRepository cabBookingsRepository;
	
	public CabBookingServiceImplementation(CabBookingsRepository cabBookingsRepository) {
		super();
		this.cabBookingsRepository = cabBookingsRepository;
	}

	@Override
	public Cabbookings addCabBooking(Cabbookings cabBookings) {
		return cabBookingsRepository.save(cabBookings);
	}
}
