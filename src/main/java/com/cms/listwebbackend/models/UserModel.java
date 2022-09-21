package com.cms.listwebbackend.models;

import com.cms.listwebbackend.entities.AbstractEntity;
import lombok.Data;

@Data
public class UserModel extends AbstractEntity {

    private String firstName;

    private String lastName;
}
