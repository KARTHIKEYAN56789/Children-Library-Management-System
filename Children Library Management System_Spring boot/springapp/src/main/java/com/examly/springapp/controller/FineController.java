package com.examly.springapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fines")
public class FineController {

    @PostMapping
    public void createFine() {
        //
    }

    @GetMapping
    public void getFines() {
        //
    }
}
