package com.celfocus.training.spaceover.spacefleet.manager.domain.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class SpaceFleet extends Auditable<String> {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @NotNull
    @NotEmpty
    private String name;

    @NotEmpty
    private String sector;

    @NotNull
    private String status;

}
