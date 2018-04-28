package net.kprod.productivity.wekanhook.data;

/**
 * Wekan card update object
 * //{ "title": "New title text", "listId": "New destination listId", "description": "New description text" }
 */
public class WekanCardUpdate {

    private String title;
    private String listId;
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getListId() {
        return listId;
    }

    public void setListId(String listId) {
        this.listId = listId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}