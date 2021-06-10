package com.celfocus.training.spaceover.spacefleet.manager.domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpaceFleetResponse {

    private Long id;
    private String name;
    private String sector;
    private String status;
}
