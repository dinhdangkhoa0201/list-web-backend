package com.cms.listwebbackend.controllers;

import com.cms.listwebbackend.constants.ConfigConstant;
import com.cms.listwebbackend.requests.CriteriaRequest;
import com.cms.listwebbackend.requests.TopicRequest;
import com.cms.listwebbackend.services.ITopicService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/topics")
@CrossOrigin(origins = ConfigConstant.FRONTEND_ORIGINS)
@Slf4j
public class TopicController {

    @Autowired
    private ITopicService iTopicService;

    @Operation(summary = "Find All")
    @GetMapping(path = "")
    public ResponseEntity<Object> findAll() {
        return new ResponseEntity<>(iTopicService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Find By Id")
    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        return new ResponseEntity<>(iTopicService.findById(id), HttpStatus.OK);
    }

    @Operation(summary = "Creat A New Topic")
    @PostMapping(path = "")
    public ResponseEntity<Object> save(@RequestBody TopicRequest request) {
        return new ResponseEntity<>(iTopicService.save(request), HttpStatus.CREATED);
    }

    @Operation(summary = "Update An Existed Topic")
    @PutMapping(path = "/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody TopicRequest request) {
        return new ResponseEntity<>(iTopicService.update(id, request), HttpStatus.OK);
    }

    @Operation(summary = "Delete An Existed Topic")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return new ResponseEntity<>(iTopicService.delete(id), HttpStatus.OK);
    }

    @Operation(summary = "Find By Criteria")
    @PostMapping(path = "/criteria")
    public ResponseEntity<Object> findByCriteria(@RequestBody CriteriaRequest request) {
        log.info("[findByCriteria] -> Called");
        return new ResponseEntity<>(iTopicService.findByCriteria(request), HttpStatus.OK);
    }
}
