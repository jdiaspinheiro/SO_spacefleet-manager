package com.celfocus.training.spaceover.spacefleet.manager.domain.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
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
