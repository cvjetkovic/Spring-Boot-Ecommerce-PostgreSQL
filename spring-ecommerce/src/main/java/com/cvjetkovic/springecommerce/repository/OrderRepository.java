package com.cvjetkovic.springecommerce.repository;

import com.cvjetkovic.springecommerce.model.order.Order;
import org.springframework.data.repository.CrudRepository;
/**
 * @author Vladimir Cvjetkovic
 */
public interface OrderRepository extends CrudRepository<Order, Long> {
}
