package com.wittybrains.busbookingsystem.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wittybrains.busbookingsystem.dto.BusDTO;
import com.wittybrains.busbookingsystem.service.BusService;




@RestController
@RequestMapping("/bus")
public class BusController {
	public BusController(BusService busService) {
        this.busService = busService;
    }
    
   private BusService busService;
    @PostMapping("/createBuses")
    public ResponseEntity<String> createBuses(@RequestBody List<BusDTO> busList) {
        List<BusDTO> createdBuses = busService.createBuses(busList);

        if (createdBuses.isEmpty()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create buses");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body("Successfully created buses");
    }

}