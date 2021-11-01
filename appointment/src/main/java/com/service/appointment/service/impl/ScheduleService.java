package com.service.appointment.service.impl;

import com.service.appointment.entity.Reserve;
import com.service.appointment.repo.ReserveRepo;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ReserveRepo reserveRepo;

    @Scheduled(cron = "0 15/60 9-21 ? * *")
    @Transactional
    public void deleteOldReserves() {
       if (!reserveRepo.getActivePassedReserves().isEmpty()){
           for (Reserve r:reserveRepo.getActivePassedReserves()) {
               System.out.println(String.format("Reserve %s was deleted", r.getDate()));
           }
           reserveRepo.deleteAll(reserveRepo.getActivePassedReserves());
       }
    }
}
