package com.aiadver.microservice.auth.service.impl;

import com.aiadver.framework.microservice.util.CommonUtils;
import com.aiadver.microservice.auth.entity.ClientInfo;
import com.aiadver.microservice.auth.repository.ClientInfoRepository;
import com.aiadver.microservice.auth.service.ClientService;
import com.aiadver.microservice.auth.translator.ClientInfoTranslator;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.ClientAlreadyExistsException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author george
 */
@Service("clientService")
public class ClientServiceImpl implements ClientService {

    @Resource(name = "passwordEncoder")
    private PasswordEncoder passwordEncoder;

    @Resource(name = "clientInfoRepository")
    private ClientInfoRepository clientInfoRepository;

    @Resource(name = "clientInfoTranslator")
    private ClientInfoTranslator clientInfoTranslator;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        ClientInfo clientInfo = clientInfoRepository.findOneByClientId(clientId);
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
        ClientInfo info = clientInfoRepository.findOneByClientId(clientInfo.getClientId());
        info = CommonUtils.combine(clientInfo, info);
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
}
