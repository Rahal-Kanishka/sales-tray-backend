package com.salestray.salestraybackend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sales_record")
@Getter
@Setter
public class SalesRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sales_record_id")
    private Long id;
    @Column(name = "created_on")
    private Date createdOn;
    @Column(name = "created_by")
    private Long createdBy;
    @Column(name = "updated_on")
    private Date updatedOn;
    @Column(name = "updated_by")
    private Long updatedBy;
    @ManyToOne
    private Retailer retailer;
    @ManyToOne
    private SaleType saleType;
    // one sale can have many items
    /*@JsonManagedReference
    @ManyToMany
    @JoinTable(
            name = "sales_record_has_stock_record",
            joinColumns = @JoinColumn(name = "sales_record_id"),
            inverseJoinColumns = @JoinColumn(name = "stock_record_id")
    )
    private Set<StockRecord> relatedStockRecords = new HashSet<>();*/

    @JsonBackReference
    @OneToMany(mappedBy = "salesRecord")
    private Set<SalesWithStockDetail> salesWithStockDetailSet = new HashSet<>();

}
