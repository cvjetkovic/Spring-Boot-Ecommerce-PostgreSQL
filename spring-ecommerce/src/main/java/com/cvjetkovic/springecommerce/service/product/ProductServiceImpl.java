package com.cvjetkovic.springecommerce.service.product;


import com.cvjetkovic.springecommerce.exception.ResourceNotFoundException;
import com.cvjetkovic.springecommerce.model.product.Product;
import com.cvjetkovic.springecommerce.model.product.response.ProductResponse;
import com.cvjetkovic.springecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vladimir Cvjetkovic
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private ProductService productService;

    @Override
    public ProductResponse getProductResponse() {

        List<Product> products = productRepository.findAll();
        List<Product> returnValue = new ArrayList<>();
        ProductResponse productResponse = new ProductResponse();

        for (Product productFromRepo : products) {
            Product product = new Product();
            product.setId(productFromRepo.getId());
            product.setName(productFromRepo.getName());
            product.setPictureUrl(productFromRepo.getPictureUrl());
            product.setPrice(productFromRepo.getPrice());
            returnValue.add(product);
        }

        productResponse.setProducts(returnValue);
        return productResponse;
    }


    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(long id) {
        return productRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product, Long id) {
        product.setId(id);
        return productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        this.productRepository.deleteById(id);
    }
}
