package com.celfocus.training.spaceover.spacefleet.manager.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiErrorResponse {
    private String code;
    private String message;
    private String reason;
    private int status;
    private String referenceError;
    private ZonedDateTime timeStamp;
}
