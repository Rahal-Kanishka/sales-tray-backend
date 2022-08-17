package com.salestray.salestraybackend.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * stands for Good Received Note. Record should be created whenever a new stock is received
 */
@Entity
@Table(name="grn")
@Getter
@Setter
public class GRN {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grn_id")
    private Long id;
    @Column(name = "buying_price")
    private Double buyingPrice;
    @Column(name = "received_quantity")
    private Long receivedQuantity;
    @ManyToOne
    private Item item;
    @ManyToOne
    private Supplier supplier;
}
