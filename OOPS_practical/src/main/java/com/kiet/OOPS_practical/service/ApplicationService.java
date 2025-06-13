package com.kiet.OOPS_practical.service;

import com.kiet.OOPS_practical.model.Application;
import com.kiet.OOPS_practical.repository.ApplicationRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ApplicationService {

    private final ApplicationRepository repository;

    public ApplicationService(ApplicationRepository repository) {
        this.repository = repository;
    }

    public List<Application> getAll() {
        return repository.findAll();
    }

    public Application getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Application> getApproved() {
        return repository.findByStatus("approved");
    }

    public Application create(Application app) {
        return repository.save(app);
    }

    public Application update(Long id, Application app) {
        Application existing = getById(id);
        if (existing != null) {
            existing.setStudentName(app.getStudentName());
            existing.setCompany(app.getCompany());
            existing.setRole(app.getRole());
            existing.setStatus(app.getStatus());
            return repository.save(existing);
        }
        return null;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
