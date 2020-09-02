package com.aiadver.microservice.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author george
 */
@Data
public class ClientModel implements ClientDetails {


    private String clientId;


    private String clientSecret;


    private Set<String> scope;


    private Set<String> resourceIds;


    private Set<String> authorizedGrantTypes;


    private Set<String> registeredRedirectUri;


    private Set<String> autoApproveScopes;

    private List<GrantedAuthority> authorities;


    private Integer accessTokenValiditySeconds;


    private Integer refreshTokenValiditySeconds;


    private Map<String, Object> additionalInformation;

    @Override
    @JsonIgnore
    public boolean isSecretRequired() {
        return this.clientSecret != null;
    }

    @Override
    @JsonIgnore
    public boolean isScoped() {
        return this.scope != null && !this.scope.isEmpty();
    }

    @Override
    @JsonIgnore
    public boolean isAutoApprove(String scope) {
        if (autoApproveScopes == null) {
            return false;
        }
        for (String auto : autoApproveScopes) {
            if (auto.equals("true") || scope.matches(auto)) {
                return true;
            }
        }
        return false;
    }
}
