package com.cvjetkovic.springecommerce.model.product.response;

import com.cvjetkovic.springecommerce.model.product.Product;

import java.util.List;
/**
 * @author Vladimir Cvjetkovic
 */
public class ProductResponse {

    List<Product> products;

    public ProductResponse() {
    }

    public ProductResponse(List<Product> products) {
        this.products = products;
    }

    public Iterable<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> item) {
        this.products = item;
    }
}
