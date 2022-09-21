
package com.cms.listwebbackend.requests;

import lombok.Data;

@Data
public class SystemConstantRequest extends AbstractRequest {

    private String code;

    private String desc;

    private String message;
}
