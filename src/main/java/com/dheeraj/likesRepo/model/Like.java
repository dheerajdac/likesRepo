package com.dheeraj.likesRepo.model;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Data;

@Data
@Table("like")
public class Like {
    
    @PrimaryKeyColumn(name = "p", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    String parentId;

    @PrimaryKeyColumn(name = "u", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    String userId;

    @Column("t")
    String type;

    @Column("l")
    boolean liked = true;

    @Column("c")
    @CreatedDate
    Date createdOn;

    @Column("m")
    @LastModifiedDate
    Date lastModifieDate;
}
