package com.cms.listwebbackend.controllers;

import com.cms.listwebbackend.requests.CollectionRequest;
import com.cms.listwebbackend.requests.CriteriaRequest;
import com.cms.listwebbackend.services.ICollectionService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/collections")
public class CollectionController {

    @Autowired
    private ICollectionService iCollectionService;

    @Operation(summary = "Find All")
    @GetMapping(path = "")
    public ResponseEntity<Object> findAll() {
        return new ResponseEntity<>(iCollectionService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Find By Id")
    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        return new ResponseEntity<>(iCollectionService.findById(id), HttpStatus.OK);
    }

    @Operation(summary = "Create A New Collection")
    @PostMapping(path = "")
    public ResponseEntity<Object> save(@RequestBody CollectionRequest request) {
        return new ResponseEntity<>(iCollectionService.save(request), HttpStatus.CREATED);
    }

    @Operation(summary = "Update An Existed Collection")
    @PutMapping(path = "/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody CollectionRequest request) {
        return new ResponseEntity<>(iCollectionService.update(id, request), HttpStatus.OK);
    }

    @Operation(summary = "Delete An Existed Collection")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return new ResponseEntity<>(iCollectionService.delete(id), HttpStatus.OK);
    }

    @Operation(summary = "Find By User Id")
    @GetMapping(path = "/users/{userId}")
    public ResponseEntity<Object> findByUser(@PathVariable Long userId) {
        return new ResponseEntity<>(iCollectionService.findByUser(userId), HttpStatus.OK);
    }

    @Operation(summary = "Find By Criteria")
    @PostMapping(path = "/criteria")
    public ResponseEntity<Object> findByCriteria(@RequestBody CriteriaRequest request) {
        return new ResponseEntity<>(iCollectionService.findByCriteria(request), HttpStatus.OK);
    }
}
