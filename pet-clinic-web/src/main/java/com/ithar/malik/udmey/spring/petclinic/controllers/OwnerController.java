package com.ithar.malik.udmey.spring.petclinic.controllers;

import com.ithar.malik.udmey.spring.petclinic.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String list(Model model) {

        model.addAttribute("owners", ownerService.findAll());

        return "owners/list";
    }

    @RequestMapping("/find")
    public String find(Model model) {

        model.addAttribute("owners", ownerService.findAll());

        return "notimplemented";
    }

}
