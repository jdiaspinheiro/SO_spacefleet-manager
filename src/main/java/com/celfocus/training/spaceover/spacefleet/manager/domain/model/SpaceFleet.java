package com.celfocus.training.spaceover.spacefleet.manager.domain.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SpaceFleet extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    private String name;

    @NotEmpty
    private String sector;

    @NotNull
    private String status;

}
