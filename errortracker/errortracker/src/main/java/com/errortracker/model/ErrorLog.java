package com.errortracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;
    private String stackTrace;
    private LocalDateTime timestamp;

    public ErrorLog(String message, String stackTrace, LocalDateTime timestamp) {
        this.message = message;
        this.stackTrace = stackTrace;
        this.timestamp = timestamp;
    }
}
