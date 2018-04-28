package net.kprod.productivity.wekanhook.controller;

import net.kprod.productivity.wekanhook.data.BeanHook;
import net.kprod.productivity.wekanhook.db.entity.EntityUniqueCardTicketId;
import net.kprod.productivity.wekanhook.db.repository.RepositoryUniqueCardTicketId;
import net.kprod.productivity.wekanhook.service.WekanCardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kemkem on 4/26/18.
 */
@RestController
@RequestMapping("/hook")
public class ControllerHook {
    private Logger LOG = LoggerFactory.getLogger(ControllerHook.class);

    public static final String WEKAN_HOOK_DESCRIPTION_CARD_CREATION = "act-createCard";
    @Autowired
    private WekanCardService cardService;

    @Autowired
    private RepositoryUniqueCardTicketId repositoryUniqueCardTicketId;

    /**
     * Webhook endpoint
     * @param beanHook body json as {@link BeanHook}
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void hook(@RequestBody BeanHook beanHook) {
        LOG.debug("Hook received [{}]", beanHook.toString());

        if(!beanHook.getDescription().equals(WEKAN_HOOK_DESCRIPTION_CARD_CREATION)) {
            LOG.debug("Not a card creation");
            return;
        }

        EntityUniqueCardTicketId entityUniqueCardTicketId = new EntityUniqueCardTicketId();
        entityUniqueCardTicketId.setCardId(beanHook.getCardId());
        entityUniqueCardTicketId = repositoryUniqueCardTicketId.save(entityUniqueCardTicketId);

        StringBuilder sbTitle = new StringBuilder();
        sbTitle.append("[").append(entityUniqueCardTicketId.getId().toString()).append("] ");
        sbTitle.append(beanHook.getCard());

        LOG.debug("Set new title [{}]", sbTitle.toString());

        cardService.updateCardTitle(beanHook.getBoardId(), beanHook.getListId(), beanHook.getCardId(), sbTitle.toString());
    }
}
