package com.service.appointment.repo;

import com.service.appointment.entity.ApiUser;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ApiUserRepo extends JpaRepository<ApiUser, Integer> {
    ApiUser findByUsername(String username);
}
