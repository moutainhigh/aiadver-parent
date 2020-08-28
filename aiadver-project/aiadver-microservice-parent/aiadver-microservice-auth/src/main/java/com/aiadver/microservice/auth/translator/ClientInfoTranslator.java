package com.aiadver.microservice.auth.translator;


import com.aiadver.framework.microservice.support.BaseTranslator;
import com.aiadver.framework.microservice.util.CommonUtils;
import com.aiadver.microservice.auth.entity.ClientInfo;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
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
        BaseClientDetails clientDetails = new BaseClientDetails();
        clientDetails.setClientId(clientInfo.getClientId());
        clientDetails.setClientSecret(clientInfo.getClientSecret());
        clientDetails.setScope(CommonUtils.getList(clientInfo.getScope()));
        clientDetails.setResourceIds(CommonUtils.getList(clientInfo.getResourceIds()));
        clientDetails.setAuthorizedGrantTypes(CommonUtils.getList(clientInfo.getAuthorizedGrantTypes()));
        clientDetails.setRegisteredRedirectUri(CommonUtils.getSet(clientInfo.getRegisteredRedirectUris()));
        clientDetails.setAutoApproveScopes(CommonUtils.getList(clientInfo.getAutoApproveScopes()));
        clientDetails.setAuthorities(roleInfoTranslator.copySourceToTarget(clientInfo.getRoleInfos()));
        clientDetails.setAccessTokenValiditySeconds(clientInfo.getAccessTokenValiditySeconds());
        clientDetails.setRefreshTokenValiditySeconds(clientInfo.getRefreshTokenValiditySeconds());
        clientDetails.setAdditionalInformation(additionalInfoTranslator.copySourceToTargetMap(clientInfo.getAdditionalInformation()));
        return clientDetails;
    }

    @Override
    public ClientInfo copyTargetToSource(ClientDetails clientDetails) {
        BaseClientDetails baseClientDetails = new BaseClientDetails(clientDetails);
        ClientInfo clientInfo = new ClientInfo();
        clientInfo.setClientId(baseClientDetails.getClientId());
        clientInfo.setClientSecret(baseClientDetails.getClientSecret());
        clientInfo.setScope(CommonUtils.getString(baseClientDetails.getScope()));
        clientInfo.setResourceIds(CommonUtils.getString(baseClientDetails.getResourceIds()));
        clientInfo.setAuthorizedGrantTypes(CommonUtils.getString(baseClientDetails.getAuthorizedGrantTypes()));
        clientInfo.setRegisteredRedirectUris(CommonUtils.getString(baseClientDetails.getRegisteredRedirectUri()));
        clientInfo.setAutoApproveScopes(CommonUtils.getString(baseClientDetails.getAutoApproveScopes()));
        clientInfo.setRoleInfos(roleInfoTranslator.copyTargetToSource(CommonUtils.getList(baseClientDetails.getAuthorities())));
        clientInfo.setAccessTokenValiditySeconds(baseClientDetails.getAccessTokenValiditySeconds());
        clientInfo.setRefreshTokenValiditySeconds(baseClientDetails.getRefreshTokenValiditySeconds());
        clientInfo.setAdditionalInformation(additionalInfoTranslator.copyTargetMapToSource(baseClientDetails.getAdditionalInformation()));
        return clientInfo;
    }

}
