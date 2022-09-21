package com.cms.listwebbackend.requests;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class TopicRequest extends AbstractRequest {

    @NotNull
    @Min(value = 0)
    @Max(value = 25)
    private String name;

    @NotNull
    @Min(value = 0)
    @Max(value = 255)
    private String description;
}
