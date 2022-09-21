package com.cms.listwebbackend.models;

import com.cms.listwebbackend.entities.AbstractEntity;
import lombok.Data;

@Data
public class IconModel extends AbstractModel {

    private String name;

    private String fileName;

    private String type;
}
