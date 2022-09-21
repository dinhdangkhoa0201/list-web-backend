package com.cms.listwebbackend.models;

import lombok.Data;

import javax.persistence.Column;

@Data
public class MenuModel extends AbstractModel {

    private int indexId;

    private String icon;

    private String code;

    private String name;

    private String objectName;

    private String desc;

    private Long menuParentId;

    private String path;
}
