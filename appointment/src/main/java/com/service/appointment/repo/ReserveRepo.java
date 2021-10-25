package com.service.appointment.repo;

import com.service.appointment.entity.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ReserveRepo extends JpaRepository<Reserve, Integer> {
}
