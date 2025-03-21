package com.project.ToolsLibrary.controller;

import com.project.ToolsLibrary.domain.dto.ReservationDto;
import com.project.ToolsLibrary.domain.entity.Reservation;
import com.project.ToolsLibrary.mapper.ReservationMapper;
import com.project.ToolsLibrary.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/reservations")
public class ReservationController {

    private final ReservationService reservationService;
    private final ReservationMapper reservationMapper;

    @Autowired
    public ReservationController(ReservationService reservationService, ReservationMapper reservationMapper) {
        this.reservationService = reservationService;
        this.reservationMapper = reservationMapper;
    }

    @GetMapping(path = "/get-Reservation/{id}")
    public ResponseEntity<ReservationDto> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(reservationMapper.toDto(reservationService.getReservationById(id)));
    }

    @GetMapping(path = "/get-Reservation-by-Members-Name/{name}")
    public ResponseEntity<List<ReservationDto>> getReservationsByMembersName(@PathVariable String name) {
        List<Reservation> reservations = reservationService.getReservationByMemberName(name);
        List<ReservationDto> reservationDtos = reservations.stream().map(reservationMapper::toDto).toList();
        return ResponseEntity.ok(reservationDtos);
    }

    @GetMapping(path = "/get-All-Reservations")
    public ResponseEntity<List<ReservationDto>> getAll() {
        List<Reservation> reservations = reservationService.getAllReservation();
        List<ReservationDto> reservationDtos = reservations.stream().map(reservationMapper::toDto).toList();
        return ResponseEntity.ok(reservationDtos);
    }

    @PostMapping
    public ResponseEntity<ReservationDto> createReservation(@RequestBody ReservationDto reservationDto) {
        Reservation reservation = reservationMapper.toEntity(reservationDto);
        Reservation savedReservationEntity = reservationService.save(reservation);
        return ResponseEntity.ok(reservationMapper.toDto(savedReservationEntity));
    }

    @PatchMapping(path = "/partial-Updates-Reservation/{id}")
    public ResponseEntity<ReservationDto> partialUpdateReservation(@PathVariable Long id, @RequestBody ReservationDto reservationDto) {
        Reservation reservation = reservationMapper.toEntity(reservationDto);
        Reservation updatedReservation = reservationService.partialUpdateReservation(id, reservation);
        return ResponseEntity.ok(reservationMapper.toDto(updatedReservation));
    }

    @DeleteMapping(path = "/delete-Reservation/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
