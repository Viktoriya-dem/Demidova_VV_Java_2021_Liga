package com.service.appointment.service.impl;

import com.service.appointment.entity.Reserve;
import com.service.appointment.service.interfaces.ReserveService;
import lombok.RequiredArgsConstructor;
import org.flywaydb.core.internal.database.DatabaseExecutionStrategy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Component
@Service
@Transactional
@RequiredArgsConstructor
public class ScheduleService {

    private final ReserveService reserveService;

    @Scheduled(cron = "0 15/60 9-21 ? * *")
    public void deleteOldReserves() {
        Date date = new Date();
        List<Reserve> reserveList = reserveService.getAllReservesForDelete();
        for (Reserve reserve : reserveList) {
            if (reserve.getDate().before(date)) {
                System.out.println(String.format("Reserve on date %s for user %s deleted", reserve.getDate().toString(), reserve.getApiUser().getUsername()));
                reserveService.deleteReserve(reserve.getId());

            }
        }

    }

}
