package com.aiadver.microservice.auth.entity;

import com.aiadver.boot.data.jpa.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author george
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class RoleInfo extends BaseEntity {

    @Column(unique = true)
    private String role;
}
