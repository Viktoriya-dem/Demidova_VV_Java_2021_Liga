package com.service.appointment.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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
@Api(value = "Customer CRUD operations", description = "Customer CRUD operations")
public class ReserveController {

private final ReserveService reserveService;
    @ApiOperation(value = "Get reserve by id for admin")
    @GetMapping("/admin/reserve/{id}")
    public ReserveDto getReserveDto(@PathVariable int id){
       return reserveService.getReserveDto(id);
    }

    @ApiOperation(value = "Delete reserve by id for admin")
    @DeleteMapping("/admin/reserve/{id}")
    public void deleteReserve(@PathVariable int id){
        ReserveDto reserveDto=reserveService.getReserveDto(id);
        reserveService.deleteReserve(id);
    }

    @ApiOperation(value = "Make reserve for user")
    @PostMapping("/user/reserve")
    public void makeReserve(Principal principal, @RequestBody ReserveDto reserveDto){
        reserveService.makeReserve(principal.getName(), reserveDto);
    }
    @ApiOperation(value = "Show active reserve for user")
    @GetMapping("/user/reserve/active")
    public List<ReserveDtoForUser> getActiveReserves(Principal principal){
        return reserveService.getActiveReserves(principal.getName());
    }

    @ApiOperation(value = "Make reserve finished for admin")
    @PutMapping("/admin/reserve/finish/{id}")
    public void makeReserveFinished(@PathVariable int id){
        reserveService.makeReserveFinished(id);
    }

    @ApiOperation(value = "Get closest reserve for admin")
    @GetMapping("/admin/reserve/closest")
    public ReserveDto getClosestReserve(){
        return reserveService.getClosestReserve();
    }

    @ApiOperation(value = "Get reserve's schedule on date for user")
    @GetMapping("/user/reserve/on-date")
    public Map<Integer, String> getActiveReservesOnCurrentDate(@RequestBody ReserveDtoOnDate reserveDtoOnDate){
        return reserveService.getActiveReservesOnCurrentDate(reserveDtoOnDate);
    }

}
