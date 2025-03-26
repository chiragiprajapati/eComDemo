package com.example.eComDemo.Controller;

import com.example.eComDemo.Model.ProductListModel;
import com.example.eComDemo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService ProdService;

    @GetMapping("status/0")
    public List<ProductListModel> findByproductStatus(){
        return ProdService.getProductsByStatus(1);
    }

//    @PostMapping("saveProduct")
//    public ProductListModel createProduct(@RequestBody ProductListModel ProdModel, @RequestBody ProductListHistoryModel ProdHisModel){
//    return ProdService.createProduct(ProdModel,ProdHisModel);
//    }

    @PostMapping("/add")
    public ProductListModel addProduct(@RequestBody ProductListModel product, @RequestParam String createdBy) {
        return ProdService.addProduct(product, createdBy);
    }

    @PutMapping("updateProduct/{id}")
    public ProductListModel updateProduct(@PathVariable Long id ,@RequestBody ProductListModel product, @RequestParam String createdBy) {
        return ProdService.updateProduct(id,product, createdBy);
    }


//    @PutMapping("updateProduct/{id}")
//    public  ProductListModel updateProduct(@PathVariable Long id , @RequestBody ProductListModel ProdModel){
//        return ProdService.UpdateProduct(id,ProdModel);
//    }
}
