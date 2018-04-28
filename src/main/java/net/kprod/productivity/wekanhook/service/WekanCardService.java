package net.kprod.productivity.wekanhook.service;

/**
 * Created by kemkem on 4/26/18.
 */
public interface WekanCardService {
    /**
     * Request Wekan card title update
     * @param boardId boardId
     * @param fromListId listId
     * @param cardId cardId
     * @param title New title
     */
    void updateCardTitle(String boardId, String fromListId, String cardId, String title);
}
