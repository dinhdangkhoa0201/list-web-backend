package com.cms.listwebbackend.requests;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class AbstractRequest {
    private Long id;

    @NotNull
    private String createBy;

    @NotNull
    private LocalDateTime createDate;

    @NotNull
    private String updateBy;

    @NotNull
    private LocalDateTime updateDate;
}
