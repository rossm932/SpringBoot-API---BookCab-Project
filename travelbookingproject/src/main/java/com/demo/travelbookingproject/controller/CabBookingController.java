package com.demo.travelbookingproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.travelbookingproject.model.CabBooking;
import com.demo.travelbookingproject.service.CabBookingService;

@Controller
public class CabBookingController {
    @Autowired
    private CabBookingService service;

    @PostMapping("/cab/book")
    @ResponseBody
    public String bookCab(@RequestParam String from, @RequestParam String to,
                          @RequestParam String typeOfCab) {
        CabBooking booking = new CabBooking();
        booking.setFromLocation(from);
        booking.setToLocation(to);
        booking.setTypeOfCab(typeOfCab);

        // Calculate the fare (using a fixed distance for this example)
        double distance = 10.0; // Example distance (you can replace this with dynamic input later)
        double fare = calculateFare(typeOfCab, distance);

        // Log or store the fare if needed
        System.out.println("Calculated fare: " + fare);

        service.saveBooking(booking);
        return "redirect:/";
    }
    
    // New Fare Calculation Endpoint
    @PostMapping("/cab/calculate-fare")
    @ResponseBody
    public double calculateFareEndpoint(@RequestParam String cabType, @RequestParam double distance) {
        return calculateFare(cabType, distance);
    }
    
    
    //GET Endpoint 
    @GetMapping("/cab/bookings")
    @ResponseBody
    public List<CabBooking> getAllBookings() {
        System.out.println("Fetching all bookings...");
        return service.getAllBookings();
    }

    
    

    // Fare Calculation Logic
    private double calculateFare(String cabType, double distance) {
        if ("Sedan".equalsIgnoreCase(cabType)) {
            return distance * 5; // 15 currency units per km
        } else if ("SUV".equalsIgnoreCase(cabType)) {
            return distance * 7; // 20 currency units per km
        } else if ("Mini".equalsIgnoreCase(cabType)) {
            return distance * 3; // 10 currency units per km
        }
        return 0;
    }
}
