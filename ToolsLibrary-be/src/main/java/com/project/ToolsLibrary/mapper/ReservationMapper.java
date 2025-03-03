package com.project.ToolsLibrary.mapper;

import com.project.ToolsLibrary.domain.dto.ReservationDto;
import com.project.ToolsLibrary.domain.entity.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ReservationMapper {
    ReservationDto toDto(Reservation reservation);
    Reservation toEntity(ReservationDto reservationDto);
}
