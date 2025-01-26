package com.errortracker.controller;

import com.errortracker.service.ErrorLogService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/errors")
public class ErrorLogController {
    private final ErrorLogService errorLogService;

    @PostMapping
    public ResponseEntity<String> receiveErrorLog(@RequestBody Map<String, String> payload) {
        System.out.println(payload);
        String message = payload.get("message");
        String stackTrace = payload.get("stackTrace");
        System.out.println(message+" "+stackTrace);
        errorLogService.saveErrorLog(message, stackTrace);
        return new ResponseEntity<>("Error log received", HttpStatus.CREATED);
    }

    public ResponseEntity<List<String>> printErrorLog(){
        return 
    }
}
