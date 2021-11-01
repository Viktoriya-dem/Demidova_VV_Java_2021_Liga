package com.service.appointment.repo;

import com.service.appointment.entity.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ReserveRepo extends JpaRepository<Reserve, Integer> {

  @Query(value="Select r from Reserve r where (r.date>current_date) and(r.isActive= true)")
  List<Reserve> getActivePassedReserves();


}
