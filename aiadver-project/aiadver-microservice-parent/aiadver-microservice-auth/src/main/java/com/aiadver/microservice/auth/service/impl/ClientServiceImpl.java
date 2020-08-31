package com.aiadver.microservice.auth.service.impl;

import com.aiadver.framework.microservice.util.CommonUtils;
import com.aiadver.microservice.auth.entity.ClientInfo;
import com.aiadver.microservice.auth.repository.ClientInfoRepository;
import com.aiadver.microservice.auth.service.AdditionalService;
import com.aiadver.microservice.auth.service.ClientService;
import com.aiadver.microservice.auth.service.RoleService;
import com.aiadver.microservice.auth.translator.ClientInfoTranslator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.ClientAlreadyExistsException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author george
 */
@Slf4j
@Service("clientService")
public class ClientServiceImpl implements ClientService {

    @Resource(name = "defaultClientDetails")
    private BaseClientDetails defaultClientDetails;

    @Resource(name = "passwordEncoder")
    private PasswordEncoder passwordEncoder;

    @Resource(name = "roleService")
    private RoleService roleService;

    @Resource(name = "additionalService")
    private AdditionalService additionalService;

    @Resource(name = "clientInfoRepository")
    private ClientInfoRepository clientInfoRepository;

    @Resource(name = "clientInfoTranslator")
    private ClientInfoTranslator clientInfoTranslator;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        ClientInfo clientInfo = clientInfoRepository.getOneByClientId(clientId);
        ClientDetails clientDetails = clientInfoTranslator.copySourceToTarget(clientInfo);
        return clientDetails;
    }

    @Override
    public void addClientDetails(ClientDetails clientDetails) throws ClientAlreadyExistsException {
        ClientInfo clientInfo = clientInfoTranslator.copyTargetToSource(clientDetails);
        clientInfoRepository.save(clientInfo);
    }

    @Override
    public void updateClientDetails(ClientDetails clientDetails) throws NoSuchClientException {
        ClientInfo clientInfo = clientInfoTranslator.copyTargetToSource(clientDetails);
        updateByClientId(clientInfo);
    }

    private void updateByClientId(ClientInfo clientInfo) {
        ClientInfo info = clientInfoRepository.getOneByClientId(clientInfo.getClientId());
        info = CommonUtils.combine(clientInfo, info, true);
        clientInfoRepository.save(info);
    }

    @Override
    public void updateClientSecret(String clientId, String secret) throws NoSuchClientException {
        ClientInfo clientInfo = new ClientInfo();
        clientInfo.setClientId(clientId);
        clientInfo.setClientSecret(passwordEncoder.encode(secret));
        updateByClientId(clientInfo);
    }

    @Override
    public void removeClientDetails(String clientId) throws NoSuchClientException {
        clientInfoRepository.deleteByClientId(clientId);
    }

    @Override
    public List<ClientDetails> listClientDetails() {
        List<ClientInfo> clientInfos = clientInfoRepository.findAll();
        return clientInfoTranslator.copySourceToTarget(clientInfos);
    }

    @Override
    public void saveDefaultClient() {
        ClientInfo clientInfo = clientInfoTranslator.copyTargetToSource(defaultClientDetails);
        String clientId = defaultClientDetails.getClientId();
        log.info("clientId: " + clientId);
        ClientInfo info = clientInfoRepository.getOneByClientId(clientId);
        if (info != null) {
            clientInfo = CommonUtils.combine(clientInfo, info, false);
        }
        clientInfo.setRoleInfos(roleService.loadRoleInfos(clientInfo.getRoleInfos()));
        clientInfo.setAdditionalInformation(additionalService.loadAdditionalInfos(clientInfo.getAdditionalInformation()));
        log.info("clientInfo: " + clientInfo.toString());
        clientInfoRepository.saveAndFlush(clientInfo);
    }
}
