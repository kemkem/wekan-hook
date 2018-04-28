package net.kprod.productivity.wekanhook.db.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Unique ticket number table
 * Used to generate unique Id
 * keeps track of cardId also
 */
@Entity
@Table(name="wh_unique_card_ticket_id")
public class EntityUniqueCardTicketId {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String cardId;

    public EntityUniqueCardTicketId() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
}
