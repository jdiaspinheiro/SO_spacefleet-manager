package com.celfocus.training.spaceover.spacefleet.manager.domain.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpaceFleetRequest {

    @Id
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String sector;

    @NotEmpty
    private String status;
}
