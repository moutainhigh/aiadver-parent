package com.aiadver.microservice.auth.translator;

import com.aiadver.framework.microservice.support.BaseTranslator;
import com.aiadver.framework.microservice.util.CommonUtils;
import com.aiadver.microservice.auth.entity.UserInfo;
import com.aiadver.microservice.auth.model.UserModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author george
 */
@Component
public class UserInfoTranslator extends BaseTranslator<UserInfo, UserDetails> {

    @Resource
    private RoleInfoTranslator roleInfoTranslator;

    @Override
    public UserDetails copySourceToTarget(UserInfo userInfo) {
        UserModel model = new UserModel();
        model.setUsername(userInfo.getUsername());
        model.setPassword(userInfo.getPassword());
        model.setEnabled(userInfo.getEnabled());
        model.setAccountNonExpired(userInfo.getAccountNonExpired());
        model.setAccountNonLocked(userInfo.getAccountNonLocked());
        model.setCredentialsNonExpired(userInfo.getCredentialsNonExpired());
        model.setAuthorities(roleInfoTranslator.copySourceToTargetSet(userInfo.getRoleInfos()));
        return model;
    }

    @Override
    public UserInfo copyTargetToSource(UserDetails userDetails) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(userDetails.getUsername());
        userInfo.setPassword(userDetails.getPassword());
        userInfo.setEnabled(userDetails.isEnabled());
        userInfo.setAccountNonExpired(userDetails.isAccountNonExpired());
        userInfo.setCredentialsNonExpired(userDetails.isCredentialsNonExpired());
        userInfo.setAccountNonLocked(userDetails.isAccountNonLocked());
        userInfo.setRoleInfos(roleInfoTranslator.copyTargetToSourceList((List<GrantedAuthority>) CommonUtils.getList(userDetails.getAuthorities())));
        return userInfo;
    }
}
