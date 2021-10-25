package com.service.appointment.service.interfaces;

import com.service.appointment.dto.ReserveDto;
import com.service.appointment.dto.ReserveDtoForUser;
import com.service.appointment.entity.Reserve;

import java.util.Date;
import java.util.List;

public interface ReserveService {

    List<ReserveDto> getAllReserves();
    List<Reserve> getAllReservesForDelete();
    void saveReserve(ReserveDto reserveDto);
    ReserveDto getReserveDto(int id);
    void deleteReserve(int id);
    void makeReserve(ReserveDto reserveDto);
    List<ReserveDtoForUser> getActiveReserves(String username);
    void makeReserveFinished(int id);
    ReserveDto getClosestReserve();

}