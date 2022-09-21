package com.cms.listwebbackend.controllers;

import com.cms.listwebbackend.constants.ConfigConstant;
import com.cms.listwebbackend.requests.CriteriaRequest;
import com.cms.listwebbackend.requests.MenuRequest;
import com.cms.listwebbackend.services.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/menus")
@CrossOrigin(origins = ConfigConstant.FRONTEND_ORIGINS)
public class MenuController {

    @Autowired
    private IMenuService iMenuService;

    @PostMapping(path = "")
    public ResponseEntity<Object> save(@RequestBody MenuRequest request) {
        return new ResponseEntity<>(iMenuService.save(request), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody MenuRequest request) {
        return new ResponseEntity<>(iMenuService.update(id, request), HttpStatus.OK);
    }

    @DeleteMapping(path = "/id")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return new ResponseEntity<>(iMenuService.delete(id), HttpStatus.OK);
    }

    @GetMapping(path = "")
    public ResponseEntity<Object> findAll() {
        return new ResponseEntity<>(iMenuService.findAll(), HttpStatus.OK);
    }

    @PostMapping(path = "/criteria")
    public ResponseEntity<Object> findByCriteria(@RequestBody CriteriaRequest request) {
        return new ResponseEntity<>(iMenuService.findByCriteria(request), HttpStatus.OK);
    }

    @GetMapping(path = "/code")
    public ResponseEntity<Object> findByCode(@RequestParam String code) {
        return new ResponseEntity<>(iMenuService.findByCode(code), HttpStatus.OK);
    }

    @PostMapping(path = "/order")
    public ResponseEntity<Object> saveByOrder(@RequestBody HashMap<Long, Integer> mapIndexId) {
        return new ResponseEntity<>(iMenuService.saveByOrder(mapIndexId), HttpStatus.OK);
    }
}
