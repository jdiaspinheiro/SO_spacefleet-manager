package com.celfocus.training.spaceover.spacefleet.manager.repository;

import com.celfocus.training.spaceover.spacefleet.manager.domain.model.SpaceFleet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpaceFleetRepository extends MongoRepository<SpaceFleet, String> {

    SpaceFleet findByName(String name);
}
