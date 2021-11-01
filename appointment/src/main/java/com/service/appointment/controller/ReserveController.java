package com.service.appointment.controller;

import com.service.appointment.dto.ReserveDto;
import com.service.appointment.dto.ReserveDtoForUser;
import com.service.appointment.service.interfaces.ReserveService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ReserveController {

private final ReserveService reserveService;

    @GetMapping("/admin/reserve/get/{id}")
    public ReserveDto getReserveDto(@PathVariable int id){
       return reserveService.getReserveDto(id);
    }

    @DeleteMapping("/admin/reserve/delete/{id}")
    public void deleteReserve(@PathVariable int id){
        ReserveDto reserveDto=reserveService.getReserveDto(id);
        reserveService.deleteReserve(id);
    }

    @PostMapping("/user/reserve/make")
    public void makeReserve(Principal principal, @RequestBody ReserveDto reserveDto){
        reserveService.makeReserve(principal.getName(), reserveDto);
    }

    @GetMapping("/user/reserve/get/active")
    public List<ReserveDtoForUser> getActiveReserves(Principal principal){
        return reserveService.getActiveReserves(principal.getName());
    }

    @PutMapping("/admin/reserve/make/finished/{id}")
    public void makeReserveFinished(@PathVariable int id){
        reserveService.makeReserveFinished(id);
    }

    @GetMapping("/admin/reserve/get/closest")
    public ReserveDto getClosestReserve(){
        return reserveService.getClosestReserve();
    }

}
