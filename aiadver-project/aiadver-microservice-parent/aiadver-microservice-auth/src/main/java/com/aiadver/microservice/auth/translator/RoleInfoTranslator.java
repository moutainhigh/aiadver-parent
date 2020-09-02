package com.aiadver.microservice.auth.translator;

import com.aiadver.framework.microservice.support.BaseTranslator;
import com.aiadver.microservice.auth.entity.RoleInfo;
import com.aiadver.microservice.auth.model.AuthorityModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

/**
 * @author george
 */
@Component
public class RoleInfoTranslator extends BaseTranslator<RoleInfo, GrantedAuthority> {
    @Override
    public GrantedAuthority copySourceToTarget(RoleInfo roleInfo) {
        AuthorityModel model = new AuthorityModel();
        model.setAuthority(roleInfo.getRole());
        return model;
    }

    @Override
    public RoleInfo copyTargetToSource(GrantedAuthority grantedAuthority) {
        RoleInfo roleInfo = new RoleInfo();
        roleInfo.setRole(grantedAuthority.getAuthority());
        return roleInfo;
    }
}
