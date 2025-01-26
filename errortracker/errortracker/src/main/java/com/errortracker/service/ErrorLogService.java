package com.errortracker.service;

import com.errortracker.model.ErrorLog;
import com.errortracker.repo.ErrorLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ErrorLogService {

    private final ErrorLogRepository errorLogRepository;

    public void saveErrorLog(String message, String stackTrace) {
        ErrorLog errorLog = new ErrorLog(message, stackTrace, LocalDateTime.now());
        errorLogRepository.save(errorLog);
    }

    public Object getAllErrorLog() {
        return errorLogRepository.findAll();
    }
}
