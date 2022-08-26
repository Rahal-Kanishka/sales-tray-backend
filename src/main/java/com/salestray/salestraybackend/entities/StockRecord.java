package com.salestray.salestraybackend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "stock_record")
@Getter
@Setter
public class StockRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_record_id")
    private Long id;
    @Column(name = "balance_in_hand")
    private Long balanceInHand;
    @Column(name = "created_on")
    private Date createdOn;
    @Column(name = "created_by")
    private Long createdBy;
    @Column(name = "last_updated_on")
    private Date updatedOn;
    @Column(name = "last_updated_by")
    private Long updatedBy;
    // one stock with one Batch No
    @OneToOne
    private GRN grn;
    @JsonBackReference
    @ManyToMany(mappedBy = "relatedStockRecords")
    Set<SalesRecord> salesRecords = new HashSet<>();
}
