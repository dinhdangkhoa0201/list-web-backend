package com.cms.listwebbackend.controllers;

import com.cms.listwebbackend.constants.ConfigConstant;
import com.cms.listwebbackend.requests.CriteriaRequest;
import com.cms.listwebbackend.requests.SystemConstantRequest;
import com.cms.listwebbackend.services.ISystemConstantService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/systemConstants")
@CrossOrigin(origins = ConfigConstant.FRONTEND_ORIGINS)
public class SystemConstantController {
    @Autowired
    private ISystemConstantService iSystemConstantService;

    @Operation(summary = "Find All")
    @GetMapping(path = "")
    public ResponseEntity<Object> findAll() {
        return new ResponseEntity<>(iSystemConstantService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Find By Id")
    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        return new ResponseEntity<>(iSystemConstantService.findById(id), HttpStatus.OK);
    }

    @Operation(summary = "Create A New Collection")
    @PostMapping(path = "")
    public ResponseEntity<Object> save(@RequestBody SystemConstantRequest request) {
        return new ResponseEntity<>(iSystemConstantService.save(request), HttpStatus.CREATED);
    }

    @Operation(summary = "Update An Existed Collection")
    @PutMapping(path = "/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody SystemConstantRequest request) {
        return new ResponseEntity<>(iSystemConstantService.update(id, request), HttpStatus.OK);
    }

    @Operation(summary = "Delete An Existed Collection")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return new ResponseEntity<>(iSystemConstantService.delete(id), HttpStatus.OK);
    }

    @Operation(summary = "Find By Criteria")
    @PostMapping(path = "/criteria")
    public ResponseEntity<Object> findByCriteria(@RequestBody CriteriaRequest request) {
        return new ResponseEntity<>(iSystemConstantService.findByCriteria(request), HttpStatus.OK);
    }
}
