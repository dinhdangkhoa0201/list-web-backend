package com.cms.listwebbackend.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AbstractModel {
    private Long id;

    private String createBy;

    private LocalDateTime createDate;

    private String updateBy;

    private LocalDateTime updateDate;
}
