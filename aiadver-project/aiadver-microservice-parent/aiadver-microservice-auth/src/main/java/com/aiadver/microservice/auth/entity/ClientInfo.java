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
public class ClientInfo extends BaseEntity {

    private String clientId;

    private String clientSecret;

    private String scope;

    private String resourceIds;

    private String authorizedGrantTypes;

    private String registeredRedirectUris;

    private String autoApproveScopes;

    @ManyToMany
    private List<RoleInfo> roleInfos;

    private Integer accessTokenValiditySeconds;

    private Integer refreshTokenValiditySeconds;

    @ManyToMany
    private List<AdditionalInfo> additionalInformation;
}
