package com.ithar.malik.udmey.spring.petclinic.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.ithar.malik.udmey.spring.petclinic.model.Owner;
import com.ithar.malik.udmey.spring.petclinic.model.Pet;
import com.ithar.malik.udmey.spring.petclinic.service.PetService;
import com.ithar.malik.udmey.spring.petclinic.service.VisitService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
class VisitControllerTest {

    @Mock
    private VisitService visitService;

    @Mock
    private PetService petService;

    @InjectMocks
    private VisitController controller;

    @Test
    void visitForm() throws Exception {

        // Given
        Pet pet = new Pet();
        pet.setId(1L);

        // When
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        // Then
        mockMvc.perform(get("/owners/1/pets/" + pet.getId() + "/visits/new")
            .flashAttr("pet", pet))
            .andExpect(status().isOk())
            .andExpect(view().name(VisitController.PET_VISIT_FORM))
            .andExpect(model().attributeExists("pet"));
    }

    @Test
    void visitFormProcess() throws Exception {

        // Given
        Owner owner = new Owner();
        owner.setId(1L);

        Pet pet = new Pet();
        pet.setId(1L);
        pet.setOwner(owner);

        // When
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        // Then
        mockMvc.perform(post("/owners/" + owner.getId() + "/pets/" + pet.getId() + "/visits/new")
            .flashAttr("pet", pet))
            .andExpect(status().is3xxRedirection())
            .andExpect(view().name("redirect:/owners/" + owner.getId()));
    }
}