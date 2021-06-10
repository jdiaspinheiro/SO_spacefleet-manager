package com.celfocus.training.spaceover.spacefleet.manager.controller;

import com.celfocus.training.spaceover.spacefleet.manager.domain.model.SpaceFleet;
import com.celfocus.training.spaceover.spacefleet.manager.domain.request.SpaceFleetRequest;
import com.celfocus.training.spaceover.spacefleet.manager.domain.response.SpaceFleetResponse;
import com.celfocus.training.spaceover.spacefleet.manager.service.SpaceFleetService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/spacefleet")
@RequiredArgsConstructor
public class SpaceOverSpaceFleetController implements SpaceFleetController {

    private final ModelMapper modelMapper;
    private final SpaceFleetService spaceFleetService;

    @GetMapping
    public ResponseEntity<List<SpaceFleetResponse>> getSpaceFleets() {
        List<SpaceFleet> spaceFleets = spaceFleetService.findAll();
        List<SpaceFleetResponse> response = spaceFleets.stream()
                .map(f -> modelMapper.map(f, SpaceFleetResponse.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpaceFleetResponse> getSpaceFleet(@PathVariable Long id) {
        return ResponseEntity.ok(modelMapper.map(spaceFleetService.findBydId(id), SpaceFleetResponse.class));
        //return ResponseEntity.ok(spaceFleetService.findBydId(id));
    }

    @PostMapping
    public ResponseEntity createSpaceFleet(@RequestBody @Valid SpaceFleetRequest request) {
        spaceFleetService.save(modelMapper.map(request, SpaceFleet.class));
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SpaceFleetResponse> updateSpaceFleet(@RequestBody @Valid SpaceFleetRequest request, @PathVariable Long id) {
        SpaceFleet spaceFleet = modelMapper.map(request, SpaceFleet.class);
        spaceFleet.setId(id);
        return ResponseEntity.ok(modelMapper.map(spaceFleetService.update(spaceFleet), SpaceFleetResponse.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SpaceFleet> deleteSpaceFleet(@PathVariable Long id) {
        spaceFleetService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
