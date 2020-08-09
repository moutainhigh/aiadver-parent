package com.aiadver.api.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户信息
 *
 * @author george
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

    private Long id;

    private String username;

    private String password;

}
