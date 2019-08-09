package com.ithar.malik.udmey.spring.petclinic.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.ithar.malik.udmey.spring.petclinic.model.Owner;
import com.ithar.malik.udmey.spring.petclinic.model.Pet;
import com.ithar.malik.udmey.spring.petclinic.service.OwnerService;
import com.ithar.malik.udmey.spring.petclinic.service.PetService;
import com.ithar.malik.udmey.spring.petclinic.service.PetTypeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
class PetControllerTest {

    @Mock
    private PetService petService;

    @Mock
    private PetTypeService petTypeService;

    @Mock
    private OwnerService ownerService;

    @InjectMocks
    private PetController controller;


    @Test
    void createPetForm() throws Exception {

        // Given
        Owner owner = new Owner();
        owner.setId(1L);

        // When
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        // Then
        mockMvc.perform(get("/owners/" + owner.getId() + "/pets/new")
            .flashAttr("owner", owner))
            .andExpect(status().isOk())
            .andExpect(view().name(PetController.PET_CREATE_FORM))
            .andExpect(model().attributeExists("pet"));
    }

    @Test
    void createPetFormProcess() throws Exception {

        // Given
        Owner owner = new Owner();
        owner.setId(1L);

        Pet pet = new Pet();
        pet.setName("Dee");

        // When
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        // Then
        mockMvc.perform(post("/owners/" + owner.getId() + "/pets/new")
            .flashAttr("owner", owner)
            .flashAttr("pet", pet))
            .andExpect(status().is3xxRedirection())
            .andExpect(view().name("redirect:/owners/" + owner.getId()))
            .andExpect(model().attributeExists("owner"));
    }

    @Test
    void createPetFormProcess_Rejected() throws Exception {

        // Given
        Owner owner = new Owner();
        owner.setId(1L);

        Pet pet = new Pet();

        // When
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        // Then
        mockMvc.perform(post("/owners/" + owner.getId() + "/pets/new")
            .flashAttr("owner", owner)
            .flashAttr("pet", pet))
            .andExpect(status().isOk())
            .andExpect(view().name(PetController.PET_CREATE_FORM))
            .andExpect(model().attributeExists("pet"));
    }

    @Test
    void editPetForm() throws Exception {

        // Given
        Owner owner = new Owner();
        owner.setId(1L);

        Pet pet = new Pet();
        pet.setId(1L);

        // When
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        // Then
        mockMvc.perform(get("/owners/" + owner.getId() + "/pets/" + pet.getId() + "/edit")
            .flashAttr("owner", owner))
            .andExpect(status().isOk())
            .andExpect(view().name(PetController.PET_CREATE_FORM))
            .andExpect(model().attributeExists("pet"));
    }

    @Test
    void editPetFormProcess() throws Exception {

        // Given
        Owner owner = new Owner();
        owner.setId(1L);

        Pet pet = new Pet();
        pet.setId(1L);
        pet.setName("Dee");

        // When
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        // Then
        mockMvc.perform(post("/owners/" + owner.getId() + "/pets/" + pet.getId() + "/edit")
            .flashAttr("owner", owner)
            .flashAttr("pet", pet))
            .andExpect(status().is3xxRedirection())
            .andExpect(view().name("redirect:/owners/" + owner.getId()))
            .andExpect(model().attributeExists("owner"));
    }
}