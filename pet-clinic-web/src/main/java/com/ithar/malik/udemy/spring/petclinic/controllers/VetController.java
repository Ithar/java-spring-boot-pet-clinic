package com.ithar.malik.udemy.spring.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/vets")
@Controller
public class VetController {

    @RequestMapping({"", "/", "/index"})
    public String list() {

        return "vets/list";
    }

}
