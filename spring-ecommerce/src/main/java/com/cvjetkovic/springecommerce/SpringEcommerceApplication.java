package com.cvjetkovic.springecommerce;

import com.cvjetkovic.springecommerce.model.product.Product;
import com.cvjetkovic.springecommerce.service.product.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author Vladimir Cvjetkovic
 */
@SpringBootApplication
public class SpringEcommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringEcommerceApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ProductService productService) {
        return args -> {
            productService.save(new Product(1L, "Product1", 100.00, ""));
            productService.save(new Product(2L, "Product2", 200.00, ""));
            productService.save(new Product(3L, "Product3", 300.00, ""));
            productService.save(new Product(4L, "Product4", 400.00, ""));
            productService.save(new Product(5L, "Product5", 500.00, ""));

        };
    }
}
