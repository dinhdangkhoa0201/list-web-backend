package com.cms.listwebbackend.requests;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Data
public class WebItemRequest extends AbstractRequest {

    @NotNull
    @Max(value = 50)
    private String name;

    @Max(value = 255)
    private String description;

    private String url;

    private String imageUrl;
}
