package com.cms.listwebbackend.services;

import com.cms.listwebbackend.models.AccountModel;
import com.cms.listwebbackend.results.ObjectResult;

public interface IAccountService {
    ObjectResult<AccountModel> save();
}
