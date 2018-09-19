package com;


import javax.persistence.*;

@Entity
@Table(name = "ITEM_NEW")
public class Item {
    private Long id;
    private String description;


    @SequenceGenerator(name = "ITEM_NEW_SEQ", sequenceName = "ITEM_NEW_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ITEM_NEW_SEQ")
    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
