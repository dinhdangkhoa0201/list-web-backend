package com.cms.listwebbackend.models;

import com.cms.listwebbackend.enums.SaveStatusEnum;
import lombok.Data;

@Data
public class CrawlModel extends AbstractModel {

    private String name;

    private String url;

    private String type;

    private String country;

    private SaveStatusEnum saveStatus;
}
