package com.aiadver.microservice.auth.entity;

import com.aiadver.boot.data.jpa.base.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;

/**
 * @author george
 */
@Entity
@Data
public class RoleInfo extends BaseEntity {

    private String role;
}
