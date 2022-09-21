package com.cms.listwebbackend.entities;

import com.cms.listwebbackend.converters.SaveStatusConverter;
import com.cms.listwebbackend.enums.SaveStatusEnum;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TBL_N_CRAWL")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "ID")),
        @AttributeOverride(name = "createBy", column = @Column(name = "CREATE_BY")),
        @AttributeOverride(name = "createDate", column = @Column(name = "CREATE_DATE")),
        @AttributeOverride(name = "updateBy", column = @Column(name = "UPDATE_BY")),
        @AttributeOverride(name = "updateDate", column = @Column(name = "UPDATE_DATE"))
})
@Data
public class CrawlEntity extends AbstractEntity {

    @Column(name = "NAME")
    private String name;

    @Column(name = "URL")
    private String url;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "SAVE_STATUS")
    @Convert(converter = SaveStatusConverter.class)
    private SaveStatusEnum saveStatus;
}
