package com.celfocus.training.spaceover.spacefleet.manager.domain.request;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpaceFleetRequest {

    @NotEmpty
    private String name;

    @NotEmpty
    private String sector;

    @NotEmpty
    private String status;
}
