package com.project.ToolsLibrary.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tool_id")
    private Tool tool;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDateTime pickupDate;
    private LocalDateTime returnDate;
    private LocalDateTime actualReturnDate;
    private String status;
}

