package com.develhope.middleware_02.controllers;

import com.develhope.middleware_02.entities.Month;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/months")
public class MonthController {

    @GetMapping("/")
    public ResponseEntity<Month> getMonth(@RequestAttribute("foundMonth") Month foundMonth) {
        return ResponseEntity.ok(foundMonth);
    }


}
