package com.project.ToolsLibrary.service;

import com.project.ToolsLibrary.domain.entity.Reservation;

import java.util.List;

public interface ReservationService {
    Reservation getReservationById(Long id);
    List<Reservation> getReservationByMemberName(String memberName);
    List<Reservation> getAllReservation();
    Reservation save(Reservation reservation);
    Reservation partialUpdateReservation(Long id, Reservation reservation);
    void deleteReservation(Long id);
}
