package com.celfocus.training.spaceover.spacefleet.manager.controller;

import com.celfocus.training.spaceover.spacefleet.manager.domain.request.SpaceFleetRequest;
import com.celfocus.training.spaceover.spacefleet.manager.domain.response.SpaceFleetResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SpaceFleetController {

    ResponseEntity<List<SpaceFleetResponse>> getSpaceFleets();

    ResponseEntity<SpaceFleetResponse> getSpaceFleet(Long id);

    ResponseEntity createSpaceFleet(SpaceFleetRequest request);

    ResponseEntity<SpaceFleetResponse>  updateSpaceFleet(SpaceFleetRequest request, Long id);

    ResponseEntity deleteSpaceFleet(Long id);

}
