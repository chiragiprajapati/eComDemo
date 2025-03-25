package com.example.eComDemo.Service;

import com.example.eComDemo.Model.ProductListHistoryModel;
import com.example.eComDemo.Model.ProductListModel;
import com.example.eComDemo.Repository.ProductHistoryRepository;
import com.example.eComDemo.Repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository ProductRepo;

    @Autowired
    private ProductHistoryRepository ProdHisRepo;

    @Override
    public List<ProductListModel> getProductsByStatus(int status) {
        return ProductRepo.findByproductStatus(status);
    }

//    @Transactional
//    @Override
//    public ProductListModel createProduct(ProductListModel ProdModel,ProductListHistoryModel ProdHisModel) {
//        ProductListModel savedProduct = ProductRepo.save(ProdModel);
//
//        // Save the product history
//        ProdHisModel.setProduct_id(savedProduct.getProduct_id()); // Assuming you link history with product ID
//        ProdHisRepo.save(ProdHisModel);
//
//        // Return the saved product (you can also return some other response if needed)
//        return savedProduct;
//    }

    @Override
    public ProductListModel UpdateProduct(Long id,ProductListModel ProdModel) {
        Optional<ProductListModel> ExistProdModel = ProductRepo.findById(id);

        if(ExistProdModel.isPresent()){
            ProductListModel NewProduct = ExistProdModel.get();
            NewProduct.setProductCate(ProdModel.getProductCate());
            NewProduct.setProductDesc(ProdModel.getProductDesc());
            NewProduct.setProductName(ProdModel.getProductName());
            NewProduct.setProductStatus(ProdModel.getProductStatus());
            return ProductRepo.save(NewProduct);
        }
        return null;
    }

    @Transactional
    @Override
    public ProductListModel addProduct(ProductListModel product, String createdBy) {
        ProductListModel savedProduct = ProductRepo.save(product);

        // Save the product in the history table
        ProductListHistoryModel history = new ProductListHistoryModel();
        history.setProductId(savedProduct.getProductId());
        history.setProductName(savedProduct.getProductName());
        history.setProductCate(savedProduct.getProductCate());
        history.setProductDesc(savedProduct.getProductDesc());
        history.setProductStatus(savedProduct.getProductStatus());
        history.setCreatedBy(createdBy);
        history.setCreatedTime(LocalDateTime.now());

        ProdHisRepo.save(history);

        return savedProduct;
    }

    @Override
    public ProductListModel updateProduct(Long id,ProductListModel product, String createdBy) {

        Optional<ProductListModel> ExistProdModel = ProductRepo.findById(id);

        if(ExistProdModel.isPresent()){
            ProductListModel NewProduct = ExistProdModel.get();
            NewProduct.setProductCate(product.getProductCate());
            NewProduct.setProductDesc(product.getProductDesc());
            NewProduct.setProductName(product.getProductName());
            NewProduct.setProductStatus(product.getProductStatus());


            ProductListHistoryModel history = new ProductListHistoryModel();
            history.setProductId(NewProduct.getProductId());
            history.setProductName(NewProduct.getProductName());
            history.setProductCate(NewProduct.getProductCate());
            history.setProductDesc(NewProduct.getProductDesc());
            history.setProductStatus(NewProduct.getProductStatus());
            history.setCreatedBy(createdBy);
            history.setCreatedTime(LocalDateTime.now());

            ProdHisRepo.save(history);

            return ProductRepo.save(NewProduct);
        }
        return null;
    }

//    @Override
//    public ProductListHistoryModel createProductHistory(ProductListHistoryModel ProdHistory) {
//        return ProdHisRepo.save(ProdHistory);
//    }
}
