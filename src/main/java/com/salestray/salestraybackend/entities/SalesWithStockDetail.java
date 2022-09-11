package com.salestray.salestraybackend.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="sales_record_has_stock_record")
public class SalesWithStockDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sales_with_stock_id")
    private Long id;

    // setting up the many-to-many relationships
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="stock_record_id")
    private StockRecord stockRecord;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="sales_record_id")
    private SalesRecord salesRecord;

    @Column(name = "sold_quantity", nullable = false)
    private Long soldQuantity;
    @Column(name = "sold_price", nullable = false)
    private Double soldPrice;
    @Column(name = "created_on")
    private Date createdOn;
    @Column(name = "created_by")
    private Long createdBy;
    @Column(name = "updated_on")
    private Date updatedOn;
    @Column(name = "updated_by")
    private Long updatedBy;
}
