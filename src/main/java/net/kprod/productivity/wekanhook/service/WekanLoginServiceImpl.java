package net.kprod.productivity.wekanhook.service;

import net.kprod.productivity.wekanhook.data.WekanLogin;
import net.kprod.productivity.wekanhook.data.WekanLoginResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by kemkem on 4/26/18.
 */
@Service
public class WekanLoginServiceImpl implements WekanLoginService {
    private Logger LOG = LoggerFactory.getLogger(WekanLoginServiceImpl.class);

    private static final String PATH_LOGIN = "/users/login";

    private String token;
    private LocalDateTime tokenExp;

    @Value("${wekan.url}")
    private String url;

    @Value("${wekan.admin.email}")
    private String adminEmail;

    @Value("${wekan.admin.password}")
    private String adminPassword;

    /**
     * {@inheritDoc}
     */
    @Override
    public String login() {
        if(!StringUtils.isEmpty(token) && tokenExp != null && LocalDateTime.now().isBefore(tokenExp)) {
            LOG.debug("Token is still valid");
            return this.token;
        }

        RestTemplate restTemplate = new RestTemplate();

        WekanLogin wekanLogin = new WekanLogin();
        wekanLogin.setEmail(adminEmail);
        wekanLogin.setPassword(adminPassword);

        ResponseEntity<WekanLoginResponse> response = restTemplate.postForEntity(url + PATH_LOGIN, wekanLogin, WekanLoginResponse.class);
        LOG.debug("login response [{}]", response);

        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

        this.tokenExp = LocalDateTime.parse(response.getBody().getTokenExpires(), formatter);

        this.token = response.getBody().getToken();
        return this.token;
    }
}
