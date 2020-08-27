package com.aiadver.boot.data.jpa.base;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author george
 */
@MappedSuperclass
@Data
public abstract class BaseEntity implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 2908475640374886321L;

    @Id
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator",
            strategy = "com.aiadver.boot.data.jpa.generator.SnowflakeIdentifierGenerator",
            parameters = {
                    @Parameter(name = "workerId", value = "1"),
                    @Parameter(name = "dataCenterId", value = "1")
            })
    private Long id;

    private String name;

    @Version
    private Timestamp timeVersion;

    private Boolean deleteFlg = false;

    private Long createUserId;

    @CreationTimestamp
    private Timestamp createTime;

    private Long updateUserId;

    @UpdateTimestamp
    private Timestamp updateTime;
}
