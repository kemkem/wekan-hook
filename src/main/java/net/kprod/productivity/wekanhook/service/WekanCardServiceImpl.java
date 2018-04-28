package net.kprod.productivity.wekanhook.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by kemkem on 4/26/18.
 */
@Service
public class WekanCardServiceImpl implements WekanCardService {
    private Logger LOG = LoggerFactory.getLogger(WekanCardServiceImpl.class);

    @Autowired
    private WekanLoginService loginService;


    @Value("${wekan.url}")
    private String url;

    private static final String PATH_CARD_UPDATE = "/api/boards/:boardId/lists/:fromListId/cards/:cardId";


    /**
     * {@inheritDoc}
     */
    @Override
    public void updateCardTitle(String boardId, String fromListId, String cardId, String title) {
        String pathCardUpdate = PATH_CARD_UPDATE;
        pathCardUpdate = pathCardUpdate.replaceAll(":boardId", boardId);
        pathCardUpdate = pathCardUpdate.replaceAll(":fromListId", fromListId);
        pathCardUpdate = pathCardUpdate.replaceAll(":cardId", cardId);

        String token = loginService.login();

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + token);

        StringBuilder sbJson = new StringBuilder();
        sbJson
                .append("{ \"title\": \"")
                .append(title)
                .append("\"}");

        HttpEntity<String> entity = new HttpEntity<>(sbJson.toString(), headers);

        ResponseEntity<String> response = restTemplate.exchange(url + pathCardUpdate, HttpMethod.PUT, entity, String.class );

        LOG.debug("cardUpdate response [{}]", response.getBody());
    }
}
