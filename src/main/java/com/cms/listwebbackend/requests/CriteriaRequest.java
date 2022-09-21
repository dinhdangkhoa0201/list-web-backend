package com.cms.listwebbackend.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CriteriaRequest {
    private HashMap<String, Object> criteria;
    private String[] orderBy;
    private int pageIndex;
    private int pageSize;
}
