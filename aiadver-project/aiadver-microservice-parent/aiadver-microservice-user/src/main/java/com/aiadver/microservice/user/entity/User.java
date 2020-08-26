package com.aiadver.microservice.user.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author george
 */
@Entity
@Data
public class User {

    @Id
    private Long id;

    private String username;

    private String password;

}
