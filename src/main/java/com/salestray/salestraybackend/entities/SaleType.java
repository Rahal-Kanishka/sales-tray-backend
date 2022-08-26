package com.salestray.salestraybackend.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sale_type")
public class SaleType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_type_id")
    private Long id;
    @Column(name = "name")
    private String name;
}
