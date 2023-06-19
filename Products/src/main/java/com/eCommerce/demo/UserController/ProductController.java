package com.eCommerce.demo.UserController;

import com.eCommerce.demo.Entity.ProductDetails;
import com.eCommerce.demo.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/users")
public class ProductController {

    private final ProductRepo productRepo;

    @Autowired
    public ProductController(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @PostMapping("/products")
    public void saveProductDetails(@RequestBody ProductDetails productDetails){
        ProductDetails product = new ProductDetails();
        product.setProduct_name(productDetails.getProduct_name());
        product.setQuantity(productDetails.getQuantity());
        product.setColor(productDetails.getColor());
        product.setPrice(productDetails.getPrice());

        productRepo.save(product);

    }
}
