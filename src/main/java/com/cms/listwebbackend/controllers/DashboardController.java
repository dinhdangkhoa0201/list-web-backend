package com.cms.listwebbackend.controllers;

import com.cms.listwebbackend.constants.ConfigConstant;
import com.cms.listwebbackend.services.IDashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin(origins = ConfigConstant.FRONTEND_ORIGINS)
public class DashboardController {

    @Autowired
    private IDashboardService iDashboardService;

    @GetMapping(path = "/dashboard/count")
    public ResponseEntity<Object> count(@RequestParam String object) {
        return new ResponseEntity<>(iDashboardService.count(object), HttpStatus.OK);
    }

}
