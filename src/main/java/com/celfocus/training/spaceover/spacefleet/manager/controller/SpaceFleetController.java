package com.celfocus.training.spaceover.spacefleet.manager.controller;

import com.celfocus.training.spaceover.spacefleet.manager.domain.request.SpaceFleetRequest;
import com.celfocus.training.spaceover.spacefleet.manager.domain.response.SpaceFleetResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SpaceFleetController {

    ResponseEntity<List<SpaceFleetResponse>> getSpaceFleets();

    ResponseEntity<Page<SpaceFleetResponse>> getSpaceFleetsPage(int pageNumber);

    ResponseEntity<SpaceFleetResponse> getSpaceFleet(String id);

    ResponseEntity createSpaceFleet(SpaceFleetRequest request);

    ResponseEntity<SpaceFleetResponse> updateSpaceFleet(SpaceFleetRequest request, String id);

    ResponseEntity deleteSpaceFleet(String id);

}
