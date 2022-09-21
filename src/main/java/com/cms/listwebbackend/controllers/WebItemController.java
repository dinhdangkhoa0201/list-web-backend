package com.cms.listwebbackend.controllers;

import com.cms.listwebbackend.constants.ConfigConstant;
import com.cms.listwebbackend.requests.CriteriaRequest;
import com.cms.listwebbackend.requests.WebItemRequest;
import com.cms.listwebbackend.services.IWebItemService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/webItems")
@CrossOrigin(origins = ConfigConstant.FRONTEND_ORIGINS)
public class WebItemController {

    @Autowired
    private IWebItemService webItemService;

    @Operation(summary = "Find All")
    @GetMapping(path = "")
    public ResponseEntity<Object> findAll() {
        return new ResponseEntity<>(webItemService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Find By Id")
    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        return new ResponseEntity<>(webItemService.findById(id), HttpStatus.OK);
    }

    @Operation(summary = "Create A New Web Item")
    @PostMapping(path = "")
    public ResponseEntity<Object> save(@RequestBody WebItemRequest request) {
        return new ResponseEntity<>(webItemService.save(request), HttpStatus.CREATED);
    }

    @Operation(summary = "Update An Existed Web Item")
    @PutMapping(path = "/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody WebItemRequest request) {
        return new ResponseEntity<>(webItemService.update(id, request), HttpStatus.OK);
    }

    @Operation(summary = "Delete An Existed Web Item")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return new ResponseEntity<>(webItemService.delete(id), HttpStatus.OK);
    }

    @Operation(summary = "Find By Topic")
    @GetMapping(path = "/topics/{topicId}")
    public ResponseEntity<Object> findByTopic(@PathVariable Long topicId) {
        return new ResponseEntity<>(webItemService.findByTopicId(topicId), HttpStatus.OK);
    }

    @Operation(summary = "Find By Collection")
    @GetMapping(path = "/collections/{collectionId}")
    public ResponseEntity<Object> findByCollection(@PathVariable Long collectionId) {
        return new ResponseEntity<>(webItemService.findByCollectionId(collectionId), HttpStatus.OK);
    }

    @Operation(summary = "Find By Criteria")
    @PostMapping(path = "/criteria")
    public ResponseEntity<Object> findByCriteria(@RequestBody CriteriaRequest request) {
        return new ResponseEntity<>(webItemService.findByCriteria(request), HttpStatus.OK);
    }
}
