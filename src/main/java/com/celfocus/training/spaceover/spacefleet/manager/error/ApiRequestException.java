package com.celfocus.training.spaceover.spacefleet.manager.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ApiRequestException extends RuntimeException {
    private String message;
}
