package com.cms.listwebbackend.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TBL_M_ICON")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "ID")),
        @AttributeOverride(name = "createBy", column = @Column(name = "CREATE_BY")),
        @AttributeOverride(name = "createDate", column = @Column(name = "CREATE_DATE")),
        @AttributeOverride(name = "updateBy", column = @Column(name = "UPDATE_BY")),
        @AttributeOverride(name = "updateDate", column = @Column(name = "UPDATE_DATE"))
})
@Data
public class IconEntity extends AbstractEntity {

    @Column(name = "NAME")
    private String name;

    @Column(name = "FILE_NAME")
    private String fileName;

    @Column(name = "TYPE")
    private String type;
}
