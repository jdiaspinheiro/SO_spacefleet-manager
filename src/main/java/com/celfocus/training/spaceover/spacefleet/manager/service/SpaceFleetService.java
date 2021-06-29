package com.celfocus.training.spaceover.spacefleet.manager.service;

import com.celfocus.training.spaceover.spacefleet.manager.domain.model.SpaceFleet;
import org.springframework.data.domain.Page;

public interface SpaceFleetService extends CrudService<SpaceFleet> {
    Page<SpaceFleet> findPaginated(int pageNumber, int pageSize);
}
