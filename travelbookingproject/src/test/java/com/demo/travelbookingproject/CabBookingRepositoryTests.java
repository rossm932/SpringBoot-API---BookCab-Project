package com.demo.travelbookingproject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.demo.travelbookingproject.model.CabBooking;
import com.demo.travelbookingproject.repository.CabBookingRepository;

@DataJpaTest
public class CabBookingRepositoryTests {

    @Autowired
    private CabBookingRepository repository;

    @Test
    public void testSaveAndRetrieveBooking() {
        CabBooking booking = new CabBooking();
        booking.setFromLocation("Home");
        booking.setToLocation("Airport");
        booking.setTypeOfCab("Sedan");

        repository.save(booking);

        List<CabBooking> bookings = repository.findAll();
        assertEquals(1, bookings.size());
        assertEquals("Home", bookings.get(0).getFromLocation());
    }
}
