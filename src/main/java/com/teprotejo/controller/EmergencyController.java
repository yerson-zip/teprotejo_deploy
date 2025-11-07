package com.teprotejo.controller;


import com.teprotejo.dto.EmergencyDto;
import com.teprotejo.entity.CAI;
import com.teprotejo.entity.Emergency;
import com.teprotejo.service.EmergencyService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emergency")
public class EmergencyController {

    private final EmergencyService emergencyService;

    public EmergencyController(EmergencyService emergencyService) {
        this.emergencyService = emergencyService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Emergency>> getAllEmergencies() {

        return  ResponseEntity.ok(emergencyService.getAllEmergencies());

    }

    @PostMapping("/create")
    public ResponseEntity<CAI> createEmergency(@Valid @RequestBody EmergencyDto emergencyDto) {

        CAI emeregency =  emergencyService.createEmergency(emergencyDto);

        return ResponseEntity.ok().body(emeregency);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmergency(@PathVariable Long id){
        HttpStatus status = emergencyService.deleteEmergency(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).build();
    }


}
