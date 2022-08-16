package com.salestray.salestraybackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Item")
@Getter @Setter
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "item_code", unique = true)
    private String code;
    @Column(name = "packing_size")
    private Integer packingSize;
    @ManyToOne
    @JsonIgnore
    private Category category;

}
