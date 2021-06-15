package com.celfocus.training.spaceover.spacefleet.manager.service;

import com.celfocus.training.spaceover.spacefleet.manager.domain.model.SpaceFleet;
import com.celfocus.training.spaceover.spacefleet.manager.repository.SpaceFleetRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SpaceOverSpaceFleetService implements SpaceFleetService {

    private final SpaceFleetRepository spaceFleetRepository;

    public List<SpaceFleet> findAll() {
        return spaceFleetRepository.findAll();
    }

    public SpaceFleet findBydId(Long id) {
        return spaceFleetRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Spacefleet with ID:" + id + " not found!"));
    }

    public SpaceFleet save(SpaceFleet entity) {
        return spaceFleetRepository.save(entity);
    }

    public SpaceFleet update(SpaceFleet entity) {
        log.trace("Updating spacefleet with ID: " + entity.getId());
        return save(entity);
    }

    public void deleteById(Long id) {
        spaceFleetRepository.deleteById(id);
        log.trace("Deleted spacefleet with ID: " + id);
    }
}
