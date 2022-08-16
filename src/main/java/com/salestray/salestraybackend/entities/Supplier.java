package com.salestray.salestraybackend.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="supplier")
@Getter
@Setter
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "code", unique = true)
    private String code;
    @Column(name = "created_on")
    private Date createdOn;
    @Column(name = "created_by")
    private Date createdBy;
    @Column(name = "address")
    private String address;
    @Column(name = "email")
    private String email;
    @Column(name = "contact_no")
    private String contactNo;
}
