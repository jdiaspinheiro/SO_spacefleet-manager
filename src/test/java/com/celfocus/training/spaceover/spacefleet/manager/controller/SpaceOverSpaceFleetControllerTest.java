package com.celfocus.training.spaceover.spacefleet.manager.controller;

import com.celfocus.training.spaceover.spacefleet.manager.domain.model.SpaceFleet;
import com.celfocus.training.spaceover.spacefleet.manager.domain.request.SpaceFleetRequest;
import com.celfocus.training.spaceover.spacefleet.manager.domain.response.SpaceFleetResponse;
import com.celfocus.training.spaceover.spacefleet.manager.service.SpaceOverSpaceFleetService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(SpaceOverSpaceFleetController.class)
class SpaceOverSpaceFleetControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SpaceOverSpaceFleetService spaceFleetService;

    @MockBean
    private ModelMapper modelMapper;

    @Test
    void getSpaceFleets() throws Exception {
        //given
        List<SpaceFleet> spaceFleets = Arrays.asList(
                SpaceFleet.builder().id(1L).name("name").sector("sector").status("status").build(),
                SpaceFleet.builder().id(2L).name("name").sector("sector").status("status").build());
        List<SpaceFleetResponse> spaceFleetResponses = Arrays.asList(
                SpaceFleetResponse.builder().id(1L).name("name").sector("sector").status("status").build(),
                SpaceFleetResponse.builder().id(2L).name("name").sector("sector").status("status").build());

        //when
        when(spaceFleetService.findAll()).thenReturn(spaceFleets);
        when(modelMapper.map(spaceFleets.get(0), SpaceFleetResponse.class)).thenReturn(spaceFleetResponses.get(0));
        when(modelMapper.map(spaceFleets.get(1), SpaceFleetResponse.class)).thenReturn(spaceFleetResponses.get(1));

        //then
        mockMvc.perform(get("/api/spacefleet/")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("name"))
                .andExpect(jsonPath("$[0].status").value("status"))
                .andExpect(jsonPath("$[0].sector").value("sector"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("name"))
                .andExpect(jsonPath("$[1].status").value("status"))
                .andExpect(jsonPath("$[1].sector").value("sector"));
    }

    @Test
    @Disabled
    void getSpaceFleet() throws Exception {
        //given
        SpaceFleet spaceFleet = SpaceFleet.builder().id(1L).status("status").sector("sector").name("name").build();
        SpaceFleetResponse response = SpaceFleetResponse.builder().id(1L).status("status").sector("sector").name("name").build();

        //when
        when(spaceFleetService.findBydId(1L)).thenReturn(spaceFleet);
        when(modelMapper.map(spaceFleet, SpaceFleetResponse.class)).thenReturn(response);

        //then
        mockMvc.perform(get("/api/spacefleet/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(header().exists("x-trace-id"))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("name"))
                .andExpect(jsonPath("$.status").value("status"))
                .andExpect(jsonPath("$.sector").value("sector"));
    }

    @Test
    @Disabled
    void createSpaceFleet() throws Exception {
        //given
        SpaceFleet spaceFleet = SpaceFleet.builder().id(1L).status("status").sector("sector").name("name").build();
        String response = new ObjectMapper().writeValueAsString(SpaceFleetResponse.builder().id(1L).status("status").sector("sector").name("name").build());

        //when
        when(modelMapper.map(response, SpaceFleet.class)).thenReturn(spaceFleet);

        //then
        mockMvc.perform(post("/api/spacefleet/")
                .content(response)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    @Disabled
    void updateSpaceFleet() throws Exception {
//        ######################################################################################################################################
//        #@PutMapping("/{id}")
//        #public ResponseEntity<SpaceFleetResponse> updateSpaceFleet(@RequestBody @Valid SpaceFleetRequest request, @PathVariable Long id) {
//        #    generateMdcUuid();
//        #    log.trace("Request to PUT (update) Spacefleet with ID: " + id);
//        #    SpaceFleet spaceFleet = modelMapper.map(request, SpaceFleet.class);
//        #    spaceFleet.setId(id);
//        #    return ResponseEntity.ok(modelMapper.map(spaceFleetService.update(spaceFleet), SpaceFleetResponse.class));
//        #}

        //given
        SpaceFleet spaceFleet = SpaceFleet.builder().id(1L).status("status").sector("sector").name("name").build();
        String toUpdate = new ObjectMapper().writeValueAsString(SpaceFleetResponse.builder().id(1L).status("status").sector("sector").name("name").build());

        //when
        when(modelMapper.map(toUpdate, SpaceFleet.class)).thenReturn(spaceFleet);

        //then
        mockMvc.perform(put("/api/spacefleet/1")
                .content(toUpdate)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    @Disabled
    void deleteSpaceFleet() throws Exception {
        //given

        //when

        //then
        mockMvc.perform(delete("/api/spacefleet/1"))
                .andExpect(status().isNoContent());
    }
}