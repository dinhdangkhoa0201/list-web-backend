package com.cms.listwebbackend.requests;

import com.cms.listwebbackend.enums.SaveStatusEnum;
import lombok.Data;

@Data
public class CrawlRequest extends AbstractRequest {

    private String name;

    private String url;

    private String type;

    private String country;

    private SaveStatusEnum saveStatus;
}
