package ch.zli.m223.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "contact_request")
public class ContactRequestModel extends PanacheEntity {

    public String message;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public UserModel user;

    @ManyToOne
    @JoinColumn(name = "item_id")
    public ItemModel item;

    public ContactRequestModel() {
    }

    public ContactRequestModel(String message, UserModel user, ItemModel item) {
        this.message = message;
        this.user = user;
        this.item = item;
    }

}
