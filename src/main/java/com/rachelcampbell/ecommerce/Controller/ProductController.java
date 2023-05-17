package com.rachelcampbell.ecommerce.Controller;

import com.rachelcampbell.ecommerce.Model.Product;
import com.rachelcampbell.ecommerce.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/product/")
public class ProductController {
    private final ProductService productService;

    //injecting ProductService into the productController
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("all")
    public List<Product> getAllProduct(){
        return this.productService.getAllProducts();
    }

    @GetMapping("{id}")
    public Product getProduct(@PathVariable int id) { return this.productService.getProductById(id);}
}
