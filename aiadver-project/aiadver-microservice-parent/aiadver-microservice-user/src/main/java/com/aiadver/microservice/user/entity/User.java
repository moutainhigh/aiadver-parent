package com.aiadver.microservice.user.entity;

import com.aiadver.boot.data.jpa.base.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;

/**
 * @author george
 */
@Entity
@Data
public class User extends BaseEntity {

    private String username;

    private String password;

}
