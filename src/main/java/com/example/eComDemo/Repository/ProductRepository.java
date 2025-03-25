package com.example.eComDemo.Repository;

import com.example.eComDemo.Model.ProductListModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<ProductListModel, Long> {
    List<ProductListModel> findByproductStatus(int status);
}
