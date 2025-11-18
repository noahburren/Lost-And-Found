package ch.zli.m223.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "category")
public class CategoryModel extends PanacheEntity {
    public String name;

    public CategoryModel() {
    }

    public CategoryModel(String name) {
        this.name = name;
    }

}
