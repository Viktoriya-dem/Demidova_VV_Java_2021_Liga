package com.service.appointment.repo;

import com.service.appointment.entity.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.List;

@Repository
public interface ReserveRepo extends JpaRepository<Reserve, Integer> {


    @Query(value = "Select r from Reserve r where r.date<=(:date) and(r.isActive=true)")
    List<Reserve> getActivePassedReserves(@Param("date") Date date);


    @Query(value = "Select r from Reserve r where date(r.date)=date(:date) and r.isActive=true")
    List<Reserve> getActiveReservesOnCurrentDate(@Param("date") Date date);

    @Query(nativeQuery = true, value = "Select * from reserves r where r.date>=current_date order by r.date asc limit 1")
    Reserve getClosestReserve();
}
