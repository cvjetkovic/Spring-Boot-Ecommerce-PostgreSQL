package com.cvjetkovic.springecommerce.repository;

import com.cvjetkovic.springecommerce.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @author Vladimir Cvjetkovic
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}
