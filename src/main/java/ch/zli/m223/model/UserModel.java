package ch.zli.m223.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UserModel extends PanacheEntity {
    public String name;
    public String email;
    public String password; // hashed
    public String role; // Admin oder User

    public UserModel() {
    }

    public UserModel(String name, String email, String password, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
