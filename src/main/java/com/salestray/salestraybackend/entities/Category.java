package com.salestray.salestraybackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="category")
@Getter
@Setter
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "date_time")
    private Date dateTime;
    // to tell relationship is already handled by the other entity
    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Item> itemList;
}
