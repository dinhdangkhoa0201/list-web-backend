package com.cms.listwebbackend.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TBL_J_TOPIC_WEB_ITEM")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "ID")),
        @AttributeOverride(name = "createBy", column = @Column(name = "CREATE_BY")),
        @AttributeOverride(name = "createDate", column = @Column(name = "CREATE_DATE")),
        @AttributeOverride(name = "updateBy", column = @Column(name = "UPDATE_BY")),
        @AttributeOverride(name = "updateDate", column = @Column(name = "UPDATE_DATE"))
})
@Data
public class TopicWebItemEntity extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "TOPIC_ID")
    TopicEntity topic;

    @ManyToOne
    @JoinColumn(name = "WEB_ITEM_ID")
    WebItemEntity webItem;
}
