package com.cms.listwebbackend.services;

import com.cms.listwebbackend.results.ObjectResult;

public interface IDashboardService {
    ObjectResult<Integer> count(String object);
}
