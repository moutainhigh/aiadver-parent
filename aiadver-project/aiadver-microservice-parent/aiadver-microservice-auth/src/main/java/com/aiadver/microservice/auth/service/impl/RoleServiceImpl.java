package com.aiadver.microservice.auth.service.impl;

import com.aiadver.microservice.auth.entity.RoleInfo;
import com.aiadver.microservice.auth.repository.RoleInfoRepository;
import com.aiadver.microservice.auth.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author george
 */
@Slf4j
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Resource(name = "roleInfoRepository")
    private RoleInfoRepository roleInfoRepository;

    @Override
    public List<RoleInfo> loadRoleInfos(List<RoleInfo> roleInfos) {
        return roleInfos.stream().map(this::loadRoleInfo).collect(Collectors.toList());
    }

    private RoleInfo loadRoleInfo(RoleInfo roleInfo) {
        String role = roleInfo.getRole();
        log.info("role: " + role);
        RoleInfo info = roleInfoRepository.getOneByRole(role);
        if (info == null) {
            log.info("roleInfo: " + roleInfo.toString());
            info = roleInfoRepository.save(roleInfo);
        }
        return info;
    }
}
