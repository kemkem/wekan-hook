package net.kprod.productivity.wekanhook.data;

/**
 * Created by kemkem on 4/26/18.
 */
public class BeanHook {

    /**
     *
     * Hook json content bean
     * https://github.com/wekan/wekan/wiki/Webhook-data
     * {
     *     text: '{{wekan-username}} added "{{card-title}}" to "{{list-name}}"\nhttp://{{wekan-host}}/b/{{board-id}}/{{board-name}}/{{card-id}}',
     *     cardId: '{{card-id}}',
     *     listId: '{{list-id}}',
     *     boardId: '{{board-id}}',
     *     user: '{{wekan-username}}',
     *     card: '{{card-title}}',
     *     description: 'act-createCard'
     * }
     */

    private String text;
    private String cardId;
    private String listId;
    private String boardId;
    private String user;
    private String card;
    private String description;


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getListId() {
        return listId;
    }

    public void setListId(String listId) {
        this.listId = listId;
    }

    public String getBoardId() {
        return boardId;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "BeanHook{" +
                "text='" + text + '\'' +
                ", cardId='" + cardId + '\'' +
                ", listId='" + listId + '\'' +
                ", boardId='" + boardId + '\'' +
                ", user='" + user + '\'' +
                ", card='" + card + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

