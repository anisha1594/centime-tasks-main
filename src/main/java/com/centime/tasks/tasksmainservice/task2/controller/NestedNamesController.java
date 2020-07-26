package com.centime.tasks.tasksmainservice.task2.controller;

import com.centime.tasks.tasksmainservice.task2.model.NestedNameResponse;
import com.centime.tasks.tasksmainservice.task2.service.NestedNamesService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NestedNamesController {

    private NestedNamesService nestedNamesService;

    public NestedNamesController(NestedNamesService nestedNamesService) {
        this.nestedNamesService = nestedNamesService;
    }

    @Operation(summary = "Fetch nested object structure based on ID")
    @GetMapping(path = "/nested-objects/{id}")
    public ResponseEntity<NestedNameResponse> fetchObjectsById(@PathVariable Long id) {
        return ResponseEntity.ok(nestedNamesService.fetchNameById(id));
    }

    @Operation(summary = "Fetch complete nested object structure")
    @GetMapping(path = "/nested-objects")
    public ResponseEntity<NestedNameResponse> fetchObjects() {
        return ResponseEntity.ok(nestedNamesService.fetchAllNames());
    }
}
