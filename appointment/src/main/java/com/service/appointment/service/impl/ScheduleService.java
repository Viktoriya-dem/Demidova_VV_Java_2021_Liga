package com.service.appointment.service.impl;

import com.service.appointment.entity.Reserve;
import com.service.appointment.repo.ReserveRepo;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;


@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ReserveRepo reserveRepo;

    @Scheduled(cron = "${cron}")
    @Transactional
    public void deleteOldReserves() {
        Date date = new Date();
        date.setHours(date.getHours() + 3);
        if (!reserveRepo.getActivePassedReserves(date).isEmpty()) {
            for (Reserve r : reserveRepo.getActivePassedReserves(date)) {
                if (r.getDate().getTime() - date.getTime() < 0) {
                    System.out.println(String.format("Reserve %s was deleted", r.getDate()));
                    reserveRepo.delete(r);
                }
            }
        }
    }
}
