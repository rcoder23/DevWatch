package com.errortracker.controller;

import com.errortracker.responsedto.ResponseHandler;
import com.errortracker.service.ErrorLogService;
import com.errortracker.util.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;


/**
 * Controller class for error loging and printing all the logs
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/errors")
public class ErrorLogController {

    private final ErrorLogService errorLogService;

    /**
     * Endpoint for saving the logs.
     *
     */
    @PostMapping
    public ResponseEntity<Object> receiveErrorLog(@RequestBody Map<String, String> payload) {
        String message = payload.get("message");
        String stackTrace = payload.get("stackTrace");
        errorLogService.saveErrorLog(message, stackTrace);
        return ResponseHandler.generateResponse(Constants.MESSAGE_ERROR_LOG_SAVED, HttpStatus.CREATED);
    }

    /**
     * Endpoint for retriving all the errors.
     *
     */
    @GetMapping
    public ResponseEntity<Object> printErrorLog(){
        return ResponseHandler.generateResponse(Constants.MESSAGE_ERROR_ALL_RECORDS,HttpStatus.OK,errorLogService.getAllErrorLog());
    }
}
