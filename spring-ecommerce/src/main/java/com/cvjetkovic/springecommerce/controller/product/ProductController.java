package com.cvjetkovic.springecommerce.controller.product;

import com.cvjetkovic.springecommerce.model.product.Product;
import com.cvjetkovic.springecommerce.model.product.response.ProductResponse;
import com.cvjetkovic.springecommerce.service.product.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
/**
 * @author Vladimir Cvjetkovic
 */
@RestController
@RequestMapping("/api/item")
public class ProductController {

    private ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //    @GetMapping(value = {"", "/"})
//    public @NotNull List<Product> getProducts() {
//        return productService.getAllProducts();
//    }
//
    @GetMapping(value = {"", "/"})
    public ProductResponse getProducts() {

        return productService.getProductResponse();

    }

    @GetMapping(value = "/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(Product product) {
        return productService.save(product);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product updateProduct(Product product, @PathVariable Long id) {
        return productService.update(product, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteEmployee(@PathVariable Long id) {
        productService.delete(id);
    }
}
