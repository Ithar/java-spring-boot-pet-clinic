package com.ithar.malik.udmey.spring.petclinic.controllers;

import com.ithar.malik.udmey.spring.petclinic.model.Owner;
import com.ithar.malik.udmey.spring.petclinic.model.Pet;
import com.ithar.malik.udmey.spring.petclinic.model.PetType;
import com.ithar.malik.udmey.spring.petclinic.service.OwnerService;
import com.ithar.malik.udmey.spring.petclinic.service.PetService;
import com.ithar.malik.udmey.spring.petclinic.service.PetTypeService;
import java.util.Collection;
import java.util.Optional;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

@Slf4j
@RequestMapping("/owners/{ownerId}/pets/")
@Controller
public class PetController {

    static final String PET_CREATE_FORM = "owners/pets/pet-form";
    private static final String PET_VISIT_FORM = "owners/pets/visit-form";

    private final PetService petService;
    private final PetTypeService petTypeService;
    private final OwnerService ownerService;

    @ModelAttribute("types")
    public Collection<PetType> populatePetTypes() {
        return petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner populateOwner(@PathVariable("ownerId") Long ownerId) {
        return ownerService.findById(ownerId);
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    public PetController(PetService petService, PetTypeService petTypeService, OwnerService ownerService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
        this.ownerService = ownerService;
    }

    // New
    @GetMapping("/new")
    public ModelAndView createPetForm(Owner owner) {

        log.info("New pet form for owner [id={}]", owner.getId());

        Pet pet = new Pet();
        pet.setOwner(owner);

        ModelAndView mav = new ModelAndView(PET_CREATE_FORM);
        mav.addObject("pet", pet);
        return mav;
    }

    @PostMapping("/new")
    public String createPetFormProcess(Model model, Owner owner, @Valid Pet pet, BindingResult result) {

        log.info("Creating new pet for owner [id={}]", owner.getId());

        // TODO [IM 19-08-09] Move this to validator
        if (StringUtils.isEmpty(pet.getName())) {
            result.rejectValue("name", "duplicate", "already exists");
        }

        if (result.hasErrors()) {
            model.addAttribute("pet", pet);
            return PET_CREATE_FORM;
        }

        ownerService.addPet(owner, pet);
        petService.save(pet);

        return "redirect:/owners/" + owner.getId();
    }

    // Edit
    @GetMapping("/{id}/edit")
    public ModelAndView editPetForm(Owner owner, @PathVariable long id) {

        log.info("Showing edit pet with [ownerId = {}, petId={}]", owner.getId(), id);

        Optional<Pet> pet = ownerService.getPetByOwner(owner, id);

        if (!pet.isPresent()) {
            return createPetForm(owner);
        }

        ModelAndView mav = new ModelAndView(PET_CREATE_FORM);
        mav.addObject("pet", pet.get());
        return mav;
    }

    @PostMapping("/{id}/edit")
    public String editPetFormProcess(Model model, Owner owner, @PathVariable long id, @Valid Pet pet, BindingResult result) {

        log.info("Processing pet edit with [ownerId = {}, petId={}]", owner.getId(), id);

        // TODO [IM 19-08-09] Move this to validator
        if (StringUtils.isEmpty(pet.getName())) {
            result.rejectValue("name", "duplicate", "already exists");
        }


        if (result.hasErrors()) {
            model.addAttribute("pet", pet);
            return PET_CREATE_FORM;
        }

        ownerService.addPet(owner, pet);
        petService.save(pet);
        return "redirect:/owners/" + owner.getId();
    }

}