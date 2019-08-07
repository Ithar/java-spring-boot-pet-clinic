package com.ithar.malik.udmey.spring.petclinic.controllers;

import com.ithar.malik.udmey.spring.petclinic.dto.OwnerDTO;
import com.ithar.malik.udmey.spring.petclinic.model.Owner;
import com.ithar.malik.udmey.spring.petclinic.service.OwnerService;
import java.util.Set;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

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

    // List Owners
    @GetMapping({"", "/", "/index", "/index.html"})
    public String list(Model model) {
        return listOwners(model, ownerService.findAll());
    }

    private String listOwners(Model model, Set<Owner> owners) {
        model.addAttribute("owners", owners);
        return "owners/list";
    }

    // View Owners
    @GetMapping("/{id}")
    public ModelAndView viewOwner(@PathVariable long id) {
        ModelAndView mav = new ModelAndView("owners/view");
        mav.addObject(ownerService.findById(id));
        return mav;
    }

    // Create owner
    @GetMapping("/new")
    public ModelAndView createOwnerForm() {
        ModelAndView mav = new ModelAndView("owners/form");
        mav.addObject("owner", new OwnerDTO());
        return mav;
    }

    @PostMapping("/new")
    public ModelAndView createOwnerFromProcess(@Valid OwnerDTO ownerDTO, BindingResult result) {

        Owner owner = ownerService.save(ownerDTO);

        ModelAndView mav = new ModelAndView("owners/" + owner.getId() + "/view");
        mav.addObject(owner);
        return mav;
    }

    // Update owner
    @GetMapping("/{id}/update")
    public ModelAndView updateOwnerForm(@PathVariable("id") int id) {
        ModelAndView mav = new ModelAndView("owners/form");
        mav.addObject(new Owner());
        return mav;
    }

    @PostMapping("/{id}/update")
    public ModelAndView updateOwnerFormProcess(@PathVariable("id") int id) {
        ModelAndView mav = new ModelAndView("owners/form");
        mav.addObject(new Owner());
        return mav;
    }

    // Find Owners
    @GetMapping("find")
    public ModelAndView findOwner() {
        ModelAndView mav = new ModelAndView("owners/find");
        mav.addObject(new Owner());
        return mav;
    }

    @PostMapping("find")
    public String findOwnerProcess(Model model, Owner owner, BindingResult result) {

        if (StringUtils.isEmpty(owner.getLastName())) {
            result.rejectValue("lastName", "notFound", "not found");
            log.warn("Cannot find owner with empty last name:" + owner.getLastName());
            return "owners/find";
        }

        String lastName = owner.getLastName();
        Set<Owner> owners = ownerService.findByLastNameLike(lastName);

        if (owners.isEmpty()) {
            result.rejectValue("lastName", "notFound", "No owner with last name '" + lastName + "' found.");
            return "owners/find";
        } else if (owners.size() == 1) {
            return "redirect:/owners/" + owners.iterator().next().getId();
        }

        return listOwners(model, owners);
    }


}
