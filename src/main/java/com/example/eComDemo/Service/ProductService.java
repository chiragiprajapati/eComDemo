package com.example.eComDemo.Service;

import com.example.eComDemo.Model.ProductListHistoryModel;
import com.example.eComDemo.Model.ProductListModel;

import java.util.List;

public interface ProductService {
    List<ProductListModel> getProductsByStatus(int status);
//    ProductListModel createProduct(ProductListModel ProdModel,ProductListHistoryModel ProdHisModel);
    ProductListModel UpdateProduct(Long id,ProductListModel ProdModel);
    public ProductListModel addProduct(ProductListModel product, String createdBy);
    public ProductListModel updateProduct(Long id,ProductListModel product, String createdBy);
//    ProductListHistoryModel createProductHistory(ProductListHistoryModel ProdHistory);
}
