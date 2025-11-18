package ch.zli.m223.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "item")
public class ItemModel extends PanacheEntity {

    public String title;
    public String description;
    public String type; // "lost" oder "found"
    public String location;

    public LocalDate date; // passt zu DATE in SQL

    @ManyToOne
    @JoinColumn(name = "category_id")
    public CategoryModel category;
}
