package com.project.ToolsLibrary.service.impl;

import com.project.ToolsLibrary.domain.entity.Reservation;
import com.project.ToolsLibrary.repository.ReservationRepository;
import com.project.ToolsLibrary.service.ReservationService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reservation Not Found"));
    }

    @Override
    public List<Reservation> getReservationByMemberName(String memberName) {
        return reservationRepository.getReservationByMemberName(memberName);
    }

    @Override
    public List<Reservation> getAllReservation() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation partialUpdateReservation(Long id, Reservation reservation) {
        return reservationRepository.findById(id).map(existingReservation -> {
            Optional.ofNullable(reservation.getTool()).ifPresent(existingReservation::setTool);
            Optional.ofNullable(reservation.getMember()).ifPresent(existingReservation::setMember);
            Optional.ofNullable(reservation.getPickupDate()).ifPresent(existingReservation::setPickupDate);
            Optional.ofNullable(reservation.getReturnDate()).ifPresent(existingReservation::setReturnDate);
            Optional.ofNullable(reservation.getActualReturnDate()).ifPresent(existingReservation::setActualReturnDate);
            Optional.ofNullable(reservation.getStatus()).ifPresent(existingReservation::setStatus);
            return reservationRepository.save(existingReservation);
        }).orElseThrow(() -> new EntityNotFoundException("Reservation Not Found"));
    }


    @Override
    public void deleteReservation(Long id) {
        if (reservationRepository.existsById(id)) {
            reservationRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Reservation Not Found");
        }
    }
}

