package com.ithar.malik.udmey.spring.petclinic.controllers;

import com.ithar.malik.udmey.spring.petclinic.model.Pet;
import com.ithar.malik.udmey.spring.petclinic.model.Visit;
import com.ithar.malik.udmey.spring.petclinic.service.PetService;
import com.ithar.malik.udmey.spring.petclinic.service.VisitService;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequestMapping("/owners/{ownerId}/pets/{petId}/visits/")
@Controller
public class VisitController {

    static final String PET_VISIT_FORM = "owners/pets/visit-form";

    private final VisitService visitService;
    private final PetService petService;

    public VisitController(VisitService visitService, PetService petService) {
        this.visitService = visitService;
        this.petService = petService;
    }

    @InitBinder("pet")
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @ModelAttribute("pet")
    public Pet populatePet(@PathVariable("petId") Long petId) {
        return petService.findById(petId);
    }

    @ModelAttribute("visit")
    public Visit populateVisit(@PathVariable("petId") Long petId) {
        return new Visit();
    }

    @GetMapping("new")
    public String visitForm(Pet pet) {
        log.info("Creating new visit [petId={}]", pet.getId());
        return PET_VISIT_FORM;
    }

    @PostMapping("new")
    public String visitFormProcess(Pet pet, @Valid Visit visit, BindingResult result) {

        log.info("Processing visit for [petId={}]", pet.getId());

        if (result.hasErrors()) {
            return PET_VISIT_FORM;
        }

        visit.setPet(pet);
        visitService.save(visit);

        return "redirect:/owners/" + pet.getOwner().getId();
    }
}