package com.teprotejo.controller;

import com.teprotejo.dto.CAIDto;
import com.teprotejo.entity.CAI;
import com.teprotejo.service.CAIService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cai")
public class CAIController {


    private final CAIService caiService;

    public CAIController(CAIService caiService) {
        this.caiService = caiService;
    }

    @GetMapping
    public ResponseEntity<?> getAllCai(){

        List<CAI> cai = caiService.findAllCai();

        HttpStatus status = !cai.isEmpty() ? HttpStatus.OK : HttpStatus.NOT_FOUND;

        return ResponseEntity.status(status).body(cai);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCaiById(@PathVariable Long id){

        CAI cai = caiService.findCaiById(id);

        HttpStatus status = cai == null? HttpStatus.NOT_FOUND : HttpStatus.OK;

        return ResponseEntity.status(status).body(cai);

    }

    @PostMapping("/create")
    public ResponseEntity<?> createCAI(@Valid @RequestBody CAIDto caiDto){

        HttpStatus status = caiService.createCai(caiDto) ?HttpStatus.OK : HttpStatus.BAD_REQUEST;

        return ResponseEntity.status(status).body(caiDto);

    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateCAI(@PathVariable Long id,@Valid @RequestBody CAIDto caiDto){

        CAI cai = caiService.updateCai(id, caiDto);

        HttpStatus status = cai!=null ? HttpStatus.OK : HttpStatus.BAD_REQUEST;

        return ResponseEntity.status(status).body(cai);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCAI(@PathVariable Long id){

        HttpStatus status = caiService.deleteCai(id) ?HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).body(status);

    }

}


