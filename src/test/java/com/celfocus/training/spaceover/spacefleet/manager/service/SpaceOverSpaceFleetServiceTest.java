package com.celfocus.training.spaceover.spacefleet.manager.service;

import com.celfocus.training.spaceover.spacefleet.manager.domain.model.SpaceFleet;
import com.celfocus.training.spaceover.spacefleet.manager.repository.SpaceFleetRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SpaceOverSpaceFleetServiceTest {

    @Mock
    private SpaceFleetRepository spaceFleetRepository;

    @InjectMocks
    private SpaceOverSpaceFleetService underTest;

    @Test
    void findAll() {
        // when
        underTest.findAll();
        //then
        verify(spaceFleetRepository, times(1)).findAll();
    }

    @Test
    void findBydId() {
    }

    @Test
    @DisplayName("Given X When I DO Y, I expect Z")
    void save() {
        // arrange
        SpaceFleet spaceFleetBeforePersistence = SpaceFleet.builder().name("nome").sector("sector").status("status").build();
        SpaceFleet spaceFleetAfterPersistence = SpaceFleet.builder().id(1L).name("nome").sector("sector").status("status").build();

        when(spaceFleetRepository.save(spaceFleetBeforePersistence)).thenReturn(spaceFleetAfterPersistence);

        // act
        SpaceFleet spaceFleetRepositoryTestById = underTest.save(spaceFleetBeforePersistence);

        // assert
        assertEquals(spaceFleetAfterPersistence, spaceFleetRepositoryTestById);
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }
}