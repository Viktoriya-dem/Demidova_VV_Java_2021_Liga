package com.service.appointment.service.impl;

import com.service.appointment.dto.ReserveDto;
import com.service.appointment.dto.ReserveDtoForUser;
import com.service.appointment.dto.ReserveDtoOnDate;
import com.service.appointment.entity.ApiUser;
import com.service.appointment.entity.Reserve;
import com.service.appointment.exception.*;
import com.service.appointment.repo.ApiUserRepo;
import com.service.appointment.repo.ReserveRepo;
import com.service.appointment.service.interfaces.ReserveService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReserveServiceImpl implements ReserveService {

    private final ReserveRepo reserveRepo;
    private final ModelMapper modelMapper;
    private final ApiUserRepo apiUserRepo;


    @Override
    public List<ReserveDto> getAllReserves() {
        List<Reserve> reserveList = reserveRepo.findAll();
        if (reserveList.size() == 0) throw new NoReserveException();
        List<ReserveDto> reserveDtos = new ArrayList<>();
        for (Reserve reserve : reserveList) {
            ReserveDto mapReserve = modelMapper.map(reserve, ReserveDto.class);
            reserveDtos.add(mapReserve);
        }
        return reserveDtos;
    }

    @Transactional
    @Override
    public void saveReserve(ReserveDto reserveDto) {
        Reserve reserve = modelMapper.map(reserveDto, Reserve.class);
        reserveRepo.save(reserve);
    }

    @Override
    public ReserveDto getReserveDto(int id) {
        ReserveDto reserveDto = null;
        Optional<Reserve> optional = reserveRepo.findById(id);
        if (optional.isPresent()) {
            reserveDto = modelMapper.map(optional.get(), ReserveDto.class);
            reserveDto.setUserId(optional.get().getApiUser().getId());
        } else throw new ReserveNotFoundException();
        return reserveDto;
    }

    @Transactional
    @Override
    public void deleteReserve(int id) {
        reserveRepo.findById(id).orElseThrow(ReserveNotFoundException::new);
        reserveRepo.deleteById(id);
    }

    @Transactional
    @Override
    public void makeReserve(String username, ReserveDto reserveDto) {
        ApiUser apiUser = apiUserRepo.findByUsername(username);
        Reserve reserve = modelMapper.map(reserveDto, Reserve.class);
        reserve.setDate(reserveDto.getDate());
        Date date = new Date();
        reserve.setActive(true);
        reserve.setApiUser(apiUser);
        List<Reserve> reserves = reserveRepo.findAll();
        boolean isFree = true;
        for (Reserve r : reserves) {
            if (r.getDate().getTime() - reserve.getDate().getTime() == 0) {
                isFree = false;
                throw new BusyReserveTimeException();
            }
        }
        if (reserve.getDate().getMinutes() == 0 && reserve.getDate().getHours() > 8
                && reserve.getDate().getHours() < 21 && isFree
                && reserve.getDate().after(date)) {
            reserveRepo.save(reserve);
        } else throw new IncorrectReserveTimeException();
        //else Exception
    }

    public List<ReserveDtoForUser> getActiveReserves(String username) {
        ApiUser apiUser = apiUserRepo.findByUsername(username);
        if (apiUser == null) throw new UserNotFoundException();
        List<ReserveDtoForUser> reserveDtos = new ArrayList<>();
        for (Reserve reserve : apiUser.getReserveList()) {
            if (reserve.isActive()) {
                reserveDtos.add(modelMapper.map(reserve, ReserveDtoForUser.class));
            }
        }
        if (reserveDtos.size() == 0) throw new NoReserveException();
        return reserveDtos;
    }

    @Transactional
    @Override
    public void makeReserveFinished(int id) {
        Reserve reserve = reserveRepo.findById(id).orElseThrow(ReserveNotFoundException::new);
        reserve.setActive(false);
        reserveRepo.save(reserve);
    }

    @Override
    public ReserveDto getClosestReserve() {
        Reserve reserve = reserveRepo.getClosestReserve();
        if (reserve == null) {
            throw new NoReserveException();
        } else return modelMapper.map(reserve, ReserveDto.class);
    }

    @Override
    public Map<Integer, String> getActiveReservesOnCurrentDate(ReserveDtoOnDate reserveDtoOnDate) {
        Map<Integer, String> map = new TreeMap<>();
        Date date = reserveDtoOnDate.getDate();
        for (int i = 9; i < 21; i++) {
            map.put(i, "Свободно");
        }
        List<Reserve> list = reserveRepo.getActiveReservesOnCurrentDate(date);
        if (list.size() == 0) {
            return map;
        }
        for (int j = 0; j < list.size(); j++) {
            if (map.containsKey(list.get(j).getDate().getHours())) {
                map.put(list.get(j).getDate().getHours(), "Занято");
            }
        }

        return map;
    }
}
