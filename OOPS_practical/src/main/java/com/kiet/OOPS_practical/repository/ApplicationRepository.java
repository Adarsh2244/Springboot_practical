package com.kiet.OOPS_practical.repository;

import com.kiet.OOPS_practical.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> findByStatus(String status);
}
