package com.cvjetkovic.springecommerce.service.product;

import com.cvjetkovic.springecommerce.model.product.Product;
import com.cvjetkovic.springecommerce.model.product.response.ProductResponse;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;
/**
 * @author Vladimir Cvjetkovic
 */
@Validated
public interface ProductService {

    @NotNull List<Product> getAllProducts();

    Product getProduct(@Min(value = 1L, message = "Invalid product ID.") long id);

    Product save(Product product);

    Product update(Product product, Long id);

    void delete(Long id);

    ProductResponse getProductResponse();
}
