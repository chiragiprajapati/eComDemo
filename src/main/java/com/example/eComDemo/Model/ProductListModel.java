package com.example.eComDemo.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "product_list")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProductListModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "product_id")
    private Long productId;

    @Column (name = "product_name")
    private String productName;
    @Column (name = "product_category")
    private String productCate;
    @Column (name = "product_description")
    private String productDesc;
    @Column (name = "product_status")
    private int productStatus;
}
