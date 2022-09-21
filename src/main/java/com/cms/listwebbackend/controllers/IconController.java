package com.cms.listwebbackend.controllers;

import com.cms.listwebbackend.constants.ConfigConstant;
import com.cms.listwebbackend.requests.CriteriaRequest;
import com.cms.listwebbackend.requests.IconRequest;
import com.cms.listwebbackend.services.IIconService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/icons")
@CrossOrigin(origins = ConfigConstant.FRONTEND_ORIGINS)
@Slf4j
public class IconController {

    @Autowired
    private IIconService iIconService;

    @Operation(summary = "Find All")
    @GetMapping(path = "")
    public ResponseEntity<Object> findAll() {
        return new ResponseEntity<>(iIconService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Find By Id")
    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @Operation(summary = "Create A New Web Item")
    @PostMapping(path = "")
    public ResponseEntity<Object> save(@RequestBody IconRequest request) {
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @Operation(summary = "Update An Existed Web Item")
    @PutMapping(path = "/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody IconRequest request) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @Operation(summary = "Delete An Existed Web Item")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @Operation(summary = "Find By Topic")
    @GetMapping(path = "/topics/{topicId}")
    public ResponseEntity<Object> findByTopic(@PathVariable Long topicId) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @Operation(summary = "Find By Collection")
    @GetMapping(path = "/collections/{collectionId}")
    public ResponseEntity<Object> findByCollection(@PathVariable Long collectionId) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @Operation(summary = "Find By Criteria")
    @PostMapping(path = "/criteria")
    public ResponseEntity<Object> findByCriteria(@RequestBody CriteriaRequest request) {
        log.info("[findByCriteria] -> Called");
        System.out.println(request);
        return new ResponseEntity<>(iIconService.findByCriteria(request), HttpStatus.OK);
    }
}
