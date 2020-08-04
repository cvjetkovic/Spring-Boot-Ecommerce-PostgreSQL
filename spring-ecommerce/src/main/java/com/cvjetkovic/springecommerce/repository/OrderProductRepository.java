package com.cvjetkovic.springecommerce.repository;


import com.cvjetkovic.springecommerce.model.order.OrderProduct;
import com.cvjetkovic.springecommerce.model.order.OrderProductPK;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Vladimir Cvjetkovic
 */
public interface OrderProductRepository extends CrudRepository<OrderProduct, OrderProductPK> {
}
