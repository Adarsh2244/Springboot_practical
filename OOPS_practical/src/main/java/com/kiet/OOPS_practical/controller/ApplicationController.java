package com.kiet.OOPS_practical.controller;

import com.kiet.OOPS_practical.model.Application;
import com.kiet.OOPS_practical.service.ApplicationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    private final ApplicationService service;

    public ApplicationController(ApplicationService service) {
        this.service = service;
    }

    @GetMapping
    public List<Application> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Application getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/status/approved")
    public List<Application> getApproved() {
        return service.getApproved();
    }

    @PostMapping
    public Application create(@RequestBody Application app) {
        return service.create(app);
    }

    @PutMapping("/{id}")
    public Application update(@PathVariable Long id, @RequestBody Application app) {
        return service.update(id, app);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
