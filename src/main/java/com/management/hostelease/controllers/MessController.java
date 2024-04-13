package com.management.hostelease.controllers;

import com.management.hostelease.model.Mess;
import com.management.hostelease.services.MessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mess")
@CrossOrigin(origins = "http://localhost:8080")
public class MessController {

    @Autowired
    private MessService messService;

    @PostMapping("/add")
    public ResponseEntity<String> addMess(@RequestBody Mess mess) {
        try {
            Mess addedMess = messService.addMess(mess);
            return ResponseEntity.ok("Mess added successfully with ID: " + addedMess.getId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add mess");
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<Mess>> getAllMesses() {
        List<Mess> messes = messService.getAllMesses();
        return ResponseEntity.ok(messes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mess> getMessById(@PathVariable int id) {
        Mess mess = messService.getMessById(id);
        if (mess != null) {
            return ResponseEntity.ok(mess);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMess(@PathVariable int id) {
        try {
            messService.deleteMess(id);
            return ResponseEntity.ok("Mess with ID " + id + " deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete mess");
        }
    }
}
