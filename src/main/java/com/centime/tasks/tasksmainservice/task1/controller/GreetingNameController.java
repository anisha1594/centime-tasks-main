package com.centime.tasks.tasksmainservice.task1.controller;

import com.centime.tasks.tasksmainservice.task1.handler.GreetingNameHandler;
import com.centime.tasks.tasksmainservice.task1.model.FullName;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
public class GreetingNameController {

    private GreetingNameHandler greetingNameHandler;

    public GreetingNameController(GreetingNameHandler greetingNameHandler) {
        this.greetingNameHandler = greetingNameHandler;
    }

    @Operation(summary = "Check the status of service")
    @GetMapping(path = "/health-check")
    public ResponseEntity<String> checkHealth() {
        return ResponseEntity.ok("Up");
    }

    @Operation(summary = "Fetch the concatenated greeting with full name elements as a string")
    @PostMapping(path = "/name-greeting")
    public ResponseEntity<String> createNameGreeting(@Valid @RequestBody FullName fullName) {
        String traceId = UUID.randomUUID().toString();
        return ResponseEntity.ok(greetingNameHandler.create(traceId, fullName));
    }
}
