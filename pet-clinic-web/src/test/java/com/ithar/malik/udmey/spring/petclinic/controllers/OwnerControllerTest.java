package com.ithar.malik.udmey.spring.petclinic.controllers;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.ithar.malik.udmey.spring.petclinic.dto.OwnerDTO;
import com.ithar.malik.udmey.spring.petclinic.model.Owner;
import com.ithar.malik.udmey.spring.petclinic.service.OwnerService;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    private OwnerService ownerService;

    @InjectMocks
    private OwnerController controller;

    private Set<Owner> owners = new HashSet<>();

    @BeforeEach
    void setUp() {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        Owner owner2 = new Owner();
        owner2.setId(2L);

        owners.add(owner1);
        owners.add(owner2);
    }

    @Test
    void list() throws Exception {

        // Given
        when(ownerService.findAll()).thenReturn(owners);

        // When
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        // Then
        mockMvc.perform(get("/owners"))
            .andExpect(status().isOk())
            .andExpect(view().name("owners/list"))
            .andExpect(model().attribute("owners", hasSize(owners.size())));
    }

    @Test
    void listByIndex() throws Exception {

        // Given setup
        when(ownerService.findAll()).thenReturn(owners);

        // When
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        // Then
        mockMvc.perform(get("/owners/index"))
            .andExpect(status().isOk())
            .andExpect(view().name("owners/list"))
            .andExpect(model().attribute("owners", hasSize(owners.size())));
    }

    @Test
    void viewOwner() throws Exception {

        // Given setup
        long id = 1L;
        Owner owner = new Owner();
        owner.setId(id);

        OwnerDTO dto = new OwnerDTO();
        dto.setId(id);

        when(ownerService.findById(any())).thenReturn(owner);
        when(ownerService.mapToDTO(any())).thenReturn(dto);

        // When
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        // Then
        mockMvc.perform(get("/owners/" + id))
            .andExpect(status().isOk())
            .andExpect(view().name("owners/view"))
            .andExpect(model().attribute("owner", hasProperty("id", is(id))));

        verify(ownerService, times(1)).findById(id);
    }

    @Test
    void findOwner() throws Exception {

        // Given setup

        // When
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        // Then
        mockMvc.perform(get("/owners/find"))
            .andExpect(status().isOk())
            .andExpect(view().name("owners/find"))
            .andExpect(model().attributeExists("owner"));
    }

    @Test
    void findOwnerProcess_NotFound() throws Exception {

        // Given
        String lastName = "Name 404";
        Set<Owner> owners = new HashSet<>();

        when(ownerService.findByLastNameLike(lastName)).thenReturn(owners);

        //When
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        // Then
        // TODO [IM 19-07-30] - Check for bindingResult value
        mockMvc.perform(post("/owners/find")
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .param("lastName", lastName))
            .andExpect(status().isOk())
            .andExpect(view().name("owners/find"));
    }

    @Test
    void findOwnerProcess_OneOwner() throws Exception {

        // Given
        long id = 1L;
        String lastName = "Doe";
        Owner owner = new Owner();
        owner.setId(id);
        owner.setLastName(lastName);

        Set<Owner> owners = new HashSet<>();
        owners.add(owner);

        when(ownerService.findByLastNameLike(lastName)).thenReturn(owners);

        //When
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        // Then
        mockMvc.perform(post("/owners/find")
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .param("lastName", lastName))
            .andExpect(status().is3xxRedirection())
            .andExpect(view().name("redirect:/owners/" + id))
            .andExpect(model().attributeExists("owner"));
    }

    @Test
    void findOwnerProcess_ManyOwners() throws Exception {

        // Given
        String lastName = "Doe";
        Owner owner = new Owner();
        owner.setLastName(lastName);

        when(ownerService.findByLastNameLike(lastName)).thenReturn(owners);

        //When
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        // Then
        mockMvc.perform(post("/owners/find")
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .param("lastName", lastName))
            .andExpect(status().isOk())
            .andExpect(view().name("owners/list"))
            .andExpect(model().attribute("owners", hasSize(2)));
    }

    @Test
    void createOwnerForm() throws Exception {

        // Given

        // When
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        // Then
        mockMvc.perform(get("/owners/new"))
            .andExpect(status().isOk())
            .andExpect(view().name("owners/form"))
            .andExpect(model().attributeExists("owner"));
    }

    @Test
    void createOwnerFormProcess() throws Exception {

        // Given
        long id = 1L;
        Owner owner = new Owner();
        owner.setId(id);

        when(ownerService.save((OwnerDTO) any())).thenReturn(owner);

        // When
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        // Then
        mockMvc.perform(post("/owners/new"))
            .andExpect(status().is3xxRedirection())
            .andExpect(view().name("redirect:/owners/" + id));
    }

    @Test
    void editOwnerForm() throws Exception {

        // Given
        long id = 1L;
        Owner owner = new Owner();
        owner.setId(id);

        when(ownerService.mapToDTO(any())).thenReturn(new OwnerDTO());

        // When
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        // Then
        mockMvc.perform(get("/owners/" + owner.getId() + "/edit"))
            .andExpect(status().isOk())
            .andExpect(view().name("owners/form"))
            .andExpect(model().attributeExists("owner"));
    }

    @Test
    void editOwnerFormProcess() throws Exception {

        // Given
        long id = 1L;

        Owner owner = new Owner();
        owner.setId(id);
        owner.setPets(new HashSet<>());

        when(ownerService.findById(id)).thenReturn(owner);
        when(ownerService.save((OwnerDTO) any())).thenReturn(owner);

        // When
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        // Then
        mockMvc.perform(post("/owners/" + id + "/edit"))
            .andExpect(status().is3xxRedirection())
            .andExpect(view().name("redirect:/owners/" + id));
    }
}