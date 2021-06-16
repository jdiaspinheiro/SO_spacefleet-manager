package com.celfocus.training.spaceover.spacefleet.manager.service;

import com.celfocus.training.spaceover.spacefleet.manager.domain.model.SpaceFleet;
import com.celfocus.training.spaceover.spacefleet.manager.repository.SpaceFleetRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SpaceOverSpaceFleetServiceTest {

    @Mock
    private SpaceFleetRepository spaceFleetRepository;

    @InjectMocks
    private SpaceOverSpaceFleetService underTest;

    @Test
    @DisplayName("GIVEN a List of spacefleets that should be found, WHEN I run the find all method, " +
            "THEN I expect the found List of spacefleets to be equal to the list of spacefleets that should be found")
    void findAll() {
        // arrange
        List<SpaceFleet> spaceFleetsToFind = new ArrayList<SpaceFleet>() {
            {
                add(SpaceFleet.builder().id(1L).name("name").sector("sector").status("status").build());
                add(SpaceFleet.builder().id(1L).name("name").sector("sector").status("status").build());
                add(SpaceFleet.builder().id(1L).name("name").sector("sector").status("status").build());
                add(SpaceFleet.builder().id(1L).name("name").sector("sector").status("status").build());
            }
        };

        when(spaceFleetRepository.findAll()).thenReturn(spaceFleetsToFind);

        // act
        List<SpaceFleet> spaceFleetsFound = underTest.findAll();

        // assert
        assertEquals(spaceFleetsFound, spaceFleetsToFind);
    }

    @Test
    @DisplayName("Given X When I DO Y, I expect Z")
    void findBydId() {
        // arrange
        SpaceFleet spaceFleetToFind = SpaceFleet.builder().id(1L).name("name").sector("sector").status("status").build();

        when(spaceFleetRepository.findById(1L)).thenReturn(Optional.of(spaceFleetToFind));

        // act
        SpaceFleet spaceFleetFoundByID = underTest.findBydId(1L);

        // assert
        assertEquals(spaceFleetFoundByID, spaceFleetToFind);
    }

    @Test
    @DisplayName("Given X When I DO Y, I expect Z")
    void save() {
        // arrange
        SpaceFleet spaceFleetBeforePersistence = SpaceFleet.builder().name("name").sector("sector").status("status").build();
        SpaceFleet spaceFleetAfterPersistence = SpaceFleet.builder().id(1L).name("name").sector("sector").status("status").build();

        when(spaceFleetRepository.save(spaceFleetBeforePersistence)).thenReturn(spaceFleetAfterPersistence);

        // act
        SpaceFleet spaceFleetSaved = underTest.save(spaceFleetBeforePersistence);

        // assert
        assertEquals(spaceFleetAfterPersistence, spaceFleetSaved);
    }

    @Test
    @DisplayName("Given X When I DO Y, I expect Z")
    void update() {
        // arrange
        SpaceFleet spaceFleetAfterUpdate = SpaceFleet.builder().id(1L).name("name2").sector("sector2").status("status2").build();

        when(spaceFleetRepository.save(spaceFleetAfterUpdate)).thenReturn(spaceFleetAfterUpdate);

        // act
        SpaceFleet spaceFleetSaved = underTest.update(spaceFleetAfterUpdate);

        // assert
        assertEquals(spaceFleetAfterUpdate, spaceFleetSaved);
    }

    @Test
    @DisplayName("Given X When I DO Y, I expect Z")
    void deleteById() {
        // act
        underTest.deleteById(1L);

        // assert
        verify(spaceFleetRepository).deleteById(1L);
    }
}