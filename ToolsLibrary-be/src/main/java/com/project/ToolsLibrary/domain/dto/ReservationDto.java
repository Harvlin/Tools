package com.project.ToolsLibrary.domain.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReservationDto {
    private Long id;
    private ToolDto toolDto;
    private MemberDto memberDto;
    private LocalDateTime pickupDate;
    private LocalDateTime returnDate;
    private LocalDateTime actualReturnDate;
    private String status;
}
