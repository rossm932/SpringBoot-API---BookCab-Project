package com.demo.travelbookingproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.travelbookingproject.model.CabBooking;

public interface CabBookingRepository extends JpaRepository<CabBooking, Long> {}
