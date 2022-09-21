package com.cms.listwebbackend.models;

import com.cms.listwebbackend.entities.AbstractEntity;
import lombok.Data;

@Data
public class TopicModel extends AbstractEntity {

    private String name;

    private String desc;
}
