package ch.zli.m223.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "contact_request")
public class ContactRequest extends PanacheEntity {

    public String message;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User user;

    @ManyToOne
    @JoinColumn(name = "item_id")
    public Item item;
}
