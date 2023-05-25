package mg.java.springbootsearchrestapi.dto;

import lombok.Getter;
import lombok.Setter;
import mg.java.springbootsearchrestapi.entity.Order;
import mg.java.springbootsearchrestapi.entity.Payment;

@Getter
@Setter
public class OrderRequest {

    private Order order;
    private Payment payment;
}
