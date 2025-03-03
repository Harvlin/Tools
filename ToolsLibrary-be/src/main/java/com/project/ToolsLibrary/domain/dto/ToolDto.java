package com.project.ToolsLibrary.domain.dto;

import lombok.Data;

import java.util.List;

@Data
public class ToolDto {
    private Long id;
    private String name;
    private String category;
    private String description;
    private String specifications;
    private String safetyRequirements;
    private String condition;
    private boolean isAvailable;
    private String qrCode;

    private List<ReservationDto> reservations;
}
