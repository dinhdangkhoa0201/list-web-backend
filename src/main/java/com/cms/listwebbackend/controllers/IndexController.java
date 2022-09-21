package com.cms.listwebbackend.controllers;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1")
@Slf4j
public class IndexController {

    @Operation(summary = "Check Healthy")
    @GetMapping(path = "")
    public ResponseEntity<Object> healthyCheck() {
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
