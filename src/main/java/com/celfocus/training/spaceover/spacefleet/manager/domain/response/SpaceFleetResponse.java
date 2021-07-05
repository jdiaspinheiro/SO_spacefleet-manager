package com.celfocus.training.spaceover.spacefleet.manager.domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class SpaceFleetResponse {

    private String id;
    private String name;
    private String sector;
    private String status;
}
