package com.project.ToolsLibrary.domain.dto;

import lombok.Data;

import java.util.List;

@Data
public class MemberDto {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private List<ReservationDto> reservations;
    private List<String> safetyCertifications;

}
