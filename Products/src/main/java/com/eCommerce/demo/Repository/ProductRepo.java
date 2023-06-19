package com.eCommerce.demo.Repository;

import com.eCommerce.demo.Entity.ProductDetails;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<ProductDetails, Long> {

}
