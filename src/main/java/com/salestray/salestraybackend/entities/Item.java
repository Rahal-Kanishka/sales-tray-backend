package com.salestray.salestraybackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
    @Column(name = "created_on")
    private Date createdOn;
    @Column(name = "created_by")
    private Long createdBy;
    @Column(name = "updated_on")
    private Date updatedOn;
    @Column(name = "updated_by")
    private Long updatedBy;
    @ManyToOne
    @JsonIgnore
    private Category category;
    // relationship already handles in GRN
    @OneToMany(mappedBy = "item")
    @JsonIgnore
    private List<GRN> grnList;

}
