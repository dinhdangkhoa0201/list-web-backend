package com.cms.listwebbackend.requests;

import com.cms.listwebbackend.entities.AbstractEntity;
import com.cms.listwebbackend.entities.UserEntity;
import lombok.Data;

@Data
public class AccountRequest extends AbstractEntity {

    private String userName;

    private String password;

    private UserEntity user;
}
