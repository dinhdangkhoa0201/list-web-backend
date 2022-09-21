
package com.cms.listwebbackend.models;

import lombok.Data;

@Data
public class SystemConstantModel extends AbstractModel {

    private String code;

    private String desc;

    private String message;
}
