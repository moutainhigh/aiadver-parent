package com.aiadver.microservice.auth.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author george
 */
@Data
public class AuthorityModel implements GrantedAuthority {

    private String authority;
}
