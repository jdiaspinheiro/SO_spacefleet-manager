package com.celfocus.training.spaceover.spacefleet.manager.service;

import com.celfocus.training.spaceover.spacefleet.manager.domain.model.SpaceFleet;
import com.celfocus.training.spaceover.spacefleet.manager.repository.SpaceFleetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SpaceOverSpaceFleetService implements SpaceFleetService {

    private final SpaceFleetRepository spaceFleetRepository;

    public List<SpaceFleet> findAll() {
        return spaceFleetRepository.findAll();
    }

    public SpaceFleet findBydId(Long id) {
        Optional<SpaceFleet> spaceFleet = spaceFleetRepository.findById(id);
        return spaceFleet.orElseThrow(EntityNotFoundException::new);
    }

    public SpaceFleet save(SpaceFleet entity) {
        return spaceFleetRepository.save(entity);
    }

    public SpaceFleet update(SpaceFleet entity) {
        return save(entity);
    }

    public void deleteById(Long id) {
        spaceFleetRepository.deleteById(id);
    }
}
