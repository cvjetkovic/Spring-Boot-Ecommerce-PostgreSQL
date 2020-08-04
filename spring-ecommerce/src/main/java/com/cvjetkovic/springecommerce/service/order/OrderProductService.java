package com.cvjetkovic.springecommerce.service.order;

import com.cvjetkovic.springecommerce.model.order.OrderProduct;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
/**
 * @author Vladimir Cvjetkovic
 */
@Validated
public interface OrderProductService {

    OrderProduct create(@NotNull(message = "The products for order cannot be null.") @Valid OrderProduct orderProduct);
}
