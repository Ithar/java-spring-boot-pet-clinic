package com.ithar.malik.udmey.spring.petclinic.controllers;

import com.ithar.malik.udmey.spring.petclinic.service.OwnerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @InitBinder
    public void securedFields(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("id"); // prevents modification of ids via forms
    }

    @GetMapping({"", "/", "/index", "/index.html"})
    public String list(Model model) {

        model.addAttribute("owners", ownerService.findAll());

        return "owners/list";
    }

    @GetMapping("/{id}")
    public ModelAndView find(@PathVariable long id) {
        ModelAndView mav = new ModelAndView("owners/view");
        mav.addObject(ownerService.findById(id));
        return mav;
    }
}
