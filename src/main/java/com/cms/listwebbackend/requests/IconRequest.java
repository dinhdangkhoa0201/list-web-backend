package com.cms.listwebbackend.requests;

import com.cms.listwebbackend.models.AbstractModel;
import lombok.Data;

@Data
public class IconRequest extends AbstractModel {

    private String name;

    private String fileName;

    private String type;
}
