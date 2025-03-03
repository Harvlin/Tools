package com.project.ToolsLibrary.repository;

import com.project.ToolsLibrary.domain.entity.Member;
import com.project.ToolsLibrary.domain.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> getReservationByMemberName(String memberName);
}
