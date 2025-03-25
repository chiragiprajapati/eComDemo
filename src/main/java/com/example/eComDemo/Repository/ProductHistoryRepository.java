package com.example.eComDemo.Repository;

import com.example.eComDemo.Model.ProductListHistoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductHistoryRepository extends JpaRepository<ProductListHistoryModel, Long> {
}
