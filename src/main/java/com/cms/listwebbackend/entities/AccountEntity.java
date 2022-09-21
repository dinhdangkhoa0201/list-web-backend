package com.cms.listwebbackend.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TBL_M_ACCOUNT")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "ID")),
        @AttributeOverride(name = "createBy", column = @Column(name = "CREATE_BY")),
        @AttributeOverride(name = "createDate", column = @Column(name = "CREATE_DATE")),
        @AttributeOverride(name = "updateBy", column = @Column(name = "UPDATE_BY")),
        @AttributeOverride(name = "updateDate", column = @Column(name = "UPDATE_DATE"))
})
@Data
public class AccountEntity extends AbstractEntity {

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "PASSWORD", columnDefinition = "LONGTEXT")
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private UserEntity user;
}
