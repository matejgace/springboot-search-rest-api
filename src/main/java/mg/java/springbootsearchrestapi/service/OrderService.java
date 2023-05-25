package mg.java.springbootsearchrestapi.service;

import mg.java.springbootsearchrestapi.dto.OrderRequest;
import mg.java.springbootsearchrestapi.dto.OrderResponse;

public interface OrderService {

    OrderResponse placeOrder(OrderRequest orderRequest);

}
