package com.aiadver.microservice.auth.entity;

import com.aiadver.boot.data.jpa.base.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * @author george
 */
@Entity
@Data
public class UserInfo extends BaseEntity {

    private String username;

    private String password;

    @ManyToMany
    private List<RoleInfo> roleInfos;

    private Boolean accountNonExpired;

    private Boolean accountNonLocked;

    private Boolean credentialsNonExpired;

    private Boolean enabled;

}
