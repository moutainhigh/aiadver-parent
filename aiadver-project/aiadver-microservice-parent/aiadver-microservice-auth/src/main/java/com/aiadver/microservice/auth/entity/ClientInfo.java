package com.aiadver.microservice.auth.entity;

import com.aiadver.boot.data.jpa.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

/**
 * @author george
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class ClientInfo extends BaseEntity {

    @Column(unique = true)
    private String clientId;

    private String clientSecret;

    private String scope;

    private String resourceIds;

    private String authorizedGrantTypes;

    private String registeredRedirectUris;

    private String autoApproveScopes;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<RoleInfo> roleInfos;

    private Integer accessTokenValiditySeconds;

    private Integer refreshTokenValiditySeconds;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<AdditionalInfo> additionalInformation;
}
