package com.cms.listwebbackend.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TBL_J_COLLECTION_WEB_ITEM")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "ID")),
        @AttributeOverride(name = "createBy", column = @Column(name = "CREATE_BY")),
        @AttributeOverride(name = "createDate", column = @Column(name = "CREATE_DATE")),
        @AttributeOverride(name = "updateBy", column = @Column(name = "UPDATE_BY")),
        @AttributeOverride(name = "updateDate", column = @Column(name = "UPDATE_DATE"))
})
@Data
public class CollectionWebItemEntity extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "COLLECTION_ID")
    private CollectionEntity collection;

    @ManyToOne
    @JoinColumn(name = "WEB_ITEM_ID")
    private WebItemEntity webItem;
}
