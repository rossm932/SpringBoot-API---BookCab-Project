package com.demo.travelbookingproject;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.demo.travelbookingproject.model.CabBooking;
import com.demo.travelbookingproject.repository.CabBookingRepository;
import com.demo.travelbookingproject.service.CabBookingService;

public class CabBookingServiceTests {

    @Mock
    private CabBookingRepository repository;

    @InjectMocks
    private CabBookingService service;

    public CabBookingServiceTests() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveBooking() {
        CabBooking booking = new CabBooking();
        booking.setFromLocation("Work");
        booking.setToLocation("Office");
        booking.setTypeOfCab("Mini");

        service.saveBooking(booking);

        verify(repository).save(booking); // Verify repository interaction
    }
}
