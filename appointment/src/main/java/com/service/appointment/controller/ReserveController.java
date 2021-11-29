package com.service.appointment.controller;

import com.service.appointment.dto.ReserveDto;
import com.service.appointment.dto.ReserveDtoForUser;
import com.service.appointment.dto.ReserveDtoOnDate;
import com.service.appointment.service.interfaces.ReserveService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ReserveController {

private final ReserveService reserveService;

    @GetMapping("/admin/reserve/{id}")
    public ReserveDto getReserveDto(@PathVariable int id){
       return reserveService.getReserveDto(id);
    }

    @DeleteMapping("/admin/reserve/{id}")
    public void deleteReserve(@PathVariable int id){
        ReserveDto reserveDto=reserveService.getReserveDto(id);
        reserveService.deleteReserve(id);
    }

    @PostMapping("/user/reserve")
    public void makeReserve(Principal principal, @RequestBody ReserveDto reserveDto){
        reserveService.makeReserve(principal.getName(), reserveDto);
    }

    @GetMapping("/user/reserve/active")
    public List<ReserveDtoForUser> getActiveReserves(Principal principal){
        return reserveService.getActiveReserves(principal.getName());
    }

    @PutMapping("/admin/reserve/finish/{id}")
    public void makeReserveFinished(@PathVariable int id){
        reserveService.makeReserveFinished(id);
    }

    @GetMapping("/admin/reserve/closest")
    public ReserveDto getClosestReserve(){
        return reserveService.getClosestReserve();
    }

    @GetMapping("/user/reserve/on-date")
    public Map<Integer, String> getActiveReservesOnCurrentDate(@RequestBody ReserveDtoOnDate reserveDtoOnDate){
        return reserveService.getActiveReservesOnCurrentDate(reserveDtoOnDate);
    }

}
