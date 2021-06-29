package com.celfocus.training.spaceover.spacefleet.manager.controller;

import com.celfocus.training.spaceover.spacefleet.manager.domain.model.SpaceFleet;
import com.celfocus.training.spaceover.spacefleet.manager.domain.request.SpaceFleetRequest;
import com.celfocus.training.spaceover.spacefleet.manager.domain.response.SpaceFleetResponse;
import com.celfocus.training.spaceover.spacefleet.manager.service.SpaceFleetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.MDC;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/spacefleet")
@RequiredArgsConstructor
public class SpaceOverSpaceFleetController implements SpaceFleetController {

    private final ModelMapper modelMapper;
    private final SpaceFleetService spaceFleetService;

    private void generateMdcUuid() {
        String requestKey = UUID.randomUUID().toString();
        MDC.put("trace-id", requestKey);
    }

    @GetMapping
    public ResponseEntity<List<SpaceFleetResponse>> getSpaceFleets() {
        generateMdcUuid();
        log.trace("Request to GET ALL Spacefleets");
        List<SpaceFleet> spaceFleets = spaceFleetService.findAll();
        List<SpaceFleetResponse> response = spaceFleets.stream()
                .map(f -> modelMapper.map(f, SpaceFleetResponse.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/page/{pageNumber}")
    public ResponseEntity<Page<SpaceFleetResponse>> getSpaceFleetsPage(@PathVariable int pageNumber) {
        int pageSize = 5; //can be implemented on URI
        generateMdcUuid();
        log.trace("Request to GET ALL Spacefleets");
        Page<SpaceFleet> page = spaceFleetService.findPaginated(pageNumber, pageSize);
        List<SpaceFleet> spaceFleets = page.getContent();
        Page<SpaceFleetResponse> response = new PageImpl<>(spaceFleets.stream()
                .map(f -> modelMapper.map(f, SpaceFleetResponse.class))
                .collect(Collectors.toList()));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpaceFleetResponse> getSpaceFleet(@PathVariable Long id) {
        generateMdcUuid();
        log.trace("Request to GET Spacefleet with ID: " + id);
        SpaceFleet bydId = spaceFleetService.findBydId(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-trace-id", MDC.get("trace-id"));
        return new ResponseEntity<>(modelMapper.map(bydId, SpaceFleetResponse.class), headers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createSpaceFleet(@RequestBody @Valid SpaceFleetRequest request) {
        generateMdcUuid();
        log.trace("Request to POST (new) Spacefleet");
        spaceFleetService.save(modelMapper.map(request, SpaceFleet.class));
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SpaceFleetResponse> updateSpaceFleet(@RequestBody @Valid SpaceFleetRequest request, @PathVariable Long id) {
        generateMdcUuid();
        log.trace("Request to PUT (update) Spacefleet with ID: " + id);
        SpaceFleet spaceFleet = modelMapper.map(request, SpaceFleet.class);
        spaceFleet.setId(id);
        return ResponseEntity.ok(modelMapper.map(spaceFleetService.update(spaceFleet), SpaceFleetResponse.class));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<SpaceFleet> deleteSpaceFleet(@PathVariable Long id) {
        generateMdcUuid();
        log.trace("Request to DELETE Spacefleet with ID: " + id);
        spaceFleetService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
