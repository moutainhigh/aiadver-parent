package com.aiadver.microservice.user.translator;

import com.aiadver.api.user.model.UserInfo;
import com.aiadver.microservice.user.entity.User;
import org.springframework.stereotype.Component;

/**
 * @author george
 */
@Component
public class UserTranslator extends BaseTranslator<User, UserInfo> {

    @Override
    public UserInfo copyEntityToModel(User user) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(user.getId());
        userInfo.setUsername(user.getUsername());
        userInfo.setPassword(user.getPassword());
        return userInfo;
    }

    @Override
    public User copyModelToEntity(UserInfo userInfo) {
        User user = new User();
        user.setId(userInfo.getId());
        user.setUsername(userInfo.getUsername());
        user.setPassword(userInfo.getPassword());
        return user;
    }
}
