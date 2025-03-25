package com.example.eComDemo.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "product_list_h")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProductListHistoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "history_id")
    private  Long historyid;
    @Column(name = "product_id")
    private Long productId;
    @Column (name = "created_by")
    private String createdBy;
    @Column (name = "created_time")
    private LocalDateTime createdTime;
    @Column (name = "product_name")
    private String productName;
    @Column (name = "product_category")
    private String productCate;
    @Column (name = "product_description")
    private String productDesc;
    @Column (name = "product_status")
    private int productStatus;

    @PrePersist
    public void prePersist() {
        // Automatically set createdTime before saving
        this.createdTime = LocalDateTime.now();
    }
}
