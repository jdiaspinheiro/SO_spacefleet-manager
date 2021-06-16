package com.celfocus.training.spaceover.spacefleet.manager.controller;

import com.celfocus.training.spaceover.spacefleet.manager.domain.model.SpaceFleet;
import com.celfocus.training.spaceover.spacefleet.manager.domain.request.SpaceFleetRequest;
import com.celfocus.training.spaceover.spacefleet.manager.service.SpaceFleetService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
class SpaceOverSpaceFleetControllerTest {

    @Mock
    private SpaceFleetService spaceFleetService;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private SpaceOverSpaceFleetController underTest;

    @Test
    void getSpaceFleets() {
        //given

        //when

        //then
    }

    @Test
    @Disabled
    void getSpaceFleet() {
        //given
        SpaceFleet spaceFleet_from_getSpaceFleet = new SpaceFleet(
                1L,
                "name",
                "sector",
                "status"
        );
        underTest.createSpaceFleet(modelMapper.map(spaceFleet_from_getSpaceFleet, SpaceFleetRequest.class));

        //when
        SpaceFleet spaceFleetRepositoryTestById = modelMapper.map(underTest.getSpaceFleet(1L), SpaceFleet.class);

        //then
        assertThat(spaceFleetRepositoryTestById).isEqualTo(spaceFleet_from_getSpaceFleet);
    }

    @Test
    @Disabled
    void createSpaceFleet() {
//        //given
//        SpaceFleet spaceFleet_from_CreateSpaceFleet = new SpaceFleet(
//                1L,
//                "name",
//                "sector",
//                "status"
//        );
//
//        //when
//        underTest.save(spaceFleet_from_CreateSpaceFleet);
//
//        //then
//        assertThat(underTest.getById(1L)).isEqualTo(spaceFleet_from_CreateSpaceFleet);
    }

    @Test
    void updateSpaceFleet() {
        //given

        //when

        //then
    }

    @Test
    void deleteSpaceFleet() {
        //given

        //when

        //then
    }
}