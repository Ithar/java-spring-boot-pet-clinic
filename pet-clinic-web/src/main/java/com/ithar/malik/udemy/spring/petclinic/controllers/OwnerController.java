package com.ithar.malik.udemy.spring.petclinic.controllers;

import com.ithar.malik.udmey.spring.petclinic.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/", "/index"})
    public String list() {

        ownerService.findAll();

        return "owners/list";
    }

}
