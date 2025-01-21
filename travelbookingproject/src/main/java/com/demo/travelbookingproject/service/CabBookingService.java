package com.demo.travelbookingproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.travelbookingproject.model.CabBooking;
import com.demo.travelbookingproject.repository.CabBookingRepository;

@Service
public class CabBookingService {
    @Autowired
    private CabBookingRepository repository;

    public CabBooking saveBooking(CabBooking booking) {
        return repository.save(booking);
        
     
    }
    
    
    public List<CabBooking> getAllBookings() {
        return repository.findAll();
    }

}