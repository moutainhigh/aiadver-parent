package com.aiadver.microservice.auth.translator;

import com.aiadver.framework.microservice.support.BaseTranslator;
import com.aiadver.framework.microservice.util.CommonUtils;
import com.aiadver.microservice.auth.entity.ClientInfo;
import com.aiadver.microservice.auth.model.ClientModel;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author george
 */
@Component
public class ClientInfoTranslator extends BaseTranslator<ClientInfo, ClientDetails> {

    @Resource
    private RoleInfoTranslator roleInfoTranslator;

    @Resource
    private AdditionalInfoTranslator additionalInfoTranslator;

    @Override
    public ClientDetails copySourceToTarget(ClientInfo clientInfo) {
        ClientModel model = new ClientModel();
        model.setClientId(clientInfo.getClientId());
        model.setClientSecret(clientInfo.getClientSecret());
        model.setScope(CommonUtils.getSet(clientInfo.getScope()));
        model.setResourceIds(CommonUtils.getSet(clientInfo.getResourceIds()));
        model.setAuthorizedGrantTypes(CommonUtils.getSet(clientInfo.getAuthorizedGrantTypes()));
        model.setRegisteredRedirectUri(CommonUtils.getSet(clientInfo.getRegisteredRedirectUris()));
        model.setAutoApproveScopes(CommonUtils.getSet(clientInfo.getAutoApproveScopes()));
        model.setAuthorities(roleInfoTranslator.copySourceToTargetList(clientInfo.getRoleInfos()));
        model.setAccessTokenValiditySeconds(clientInfo.getAccessTokenValiditySeconds());
        model.setRefreshTokenValiditySeconds(clientInfo.getRefreshTokenValiditySeconds());
        model.setAdditionalInformation(additionalInfoTranslator.copySourceToTargetMap(clientInfo.getAdditionalInformation()));
        return model;
    }

    @Override
    public ClientInfo copyTargetToSource(ClientDetails clientDetails) {
        ClientInfo clientInfo = new ClientInfo();
        clientInfo.setClientId(clientDetails.getClientId());
        clientInfo.setClientSecret(clientDetails.getClientSecret());
        clientInfo.setScope(CommonUtils.getString(clientDetails.getScope()));
        clientInfo.setResourceIds(CommonUtils.getString(clientDetails.getResourceIds()));
        clientInfo.setAuthorizedGrantTypes(CommonUtils.getString(clientDetails.getAuthorizedGrantTypes()));
        clientInfo.setRegisteredRedirectUris(CommonUtils.getString(clientDetails.getRegisteredRedirectUri()));
        clientInfo.setRoleInfos(roleInfoTranslator.copyTargetToSourceList(CommonUtils.getList(clientDetails.getAuthorities())));
        clientInfo.setAccessTokenValiditySeconds(clientDetails.getAccessTokenValiditySeconds());
        clientInfo.setRefreshTokenValiditySeconds(clientDetails.getRefreshTokenValiditySeconds());
        clientInfo.setAdditionalInformation(additionalInfoTranslator.copyTargetMapToSource(clientDetails.getAdditionalInformation()));
        return clientInfo;
    }

}
