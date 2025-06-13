package com.kiet.OOPS_practical.controller;

import com.kiet.OOPS_practical.model.Application;
import com.kiet.OOPS_practical.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {

    @Autowired
    private ApplicationRepository repository;

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("application", new Application());
        return "add-application"; // renders templates/add-application.html
    }

    @PostMapping("/save")
    public String saveApplication(@ModelAttribute Application application) {
        application.setStatus(application.getStatus().toLowerCase()); // normalize status
        repository.save(application);
        return "redirect:/form";
    }
}
