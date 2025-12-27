package com.examly.springapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/borrows")
public class BorrowController {

    @PostMapping
    public void createBorrow() {
        //
    }

    @GetMapping
    public void getBorrows() {
        //
    }

    @GetMapping("/{id}")
    public void getBorrowById(@PathVariable Long id) {
        //
    }
}
