package com.cms.listwebbackend.requests;

import lombok.Data;

@Data
public class MenuRequest extends AbstractRequest {

    private int indexId;

    private String icon;

    private String code;

    private String name;

    private String objectName;

    private String desc;

    private Long menuParentId;

    private String path;
}
