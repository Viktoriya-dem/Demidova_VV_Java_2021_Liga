package com.service.appointment.service.interfaces;

import com.service.appointment.dto.ReserveDto;
import com.service.appointment.dto.ReserveDtoForUser;
import com.service.appointment.dto.ReserveDtoOnDate;
import com.service.appointment.entity.Reserve;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ReserveService {

    List<ReserveDto> getAllReserves();
    void saveReserve(ReserveDto reserveDto);
    ReserveDto getReserveDto(int id);
    void deleteReserve(int id);
    void makeReserve(String username, ReserveDto reserveDto);
    List<ReserveDtoForUser> getActiveReserves(String username);
    void makeReserveFinished(int id);
    ReserveDto getClosestReserve();
    Map<Integer, String> getActiveReservesOnCurrentDate(ReserveDtoOnDate reserveDtoOnDate);

}
