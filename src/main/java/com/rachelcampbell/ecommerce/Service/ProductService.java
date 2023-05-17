package com.rachelcampbell.ecommerce.Service;

import com.rachelcampbell.ecommerce.Model.Product;
import com.rachelcampbell.ecommerce.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepo productRepo;

    // injecting productRepo depencency into productService
    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    /*
    * This returns a list of all the products.
    * It is used to load the shop page on the frontend
    * */
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    /*
    * This returns just one particular product.
    */
    public Product getProductById(int id) { return productRepo.findById(id).get(); }
}
