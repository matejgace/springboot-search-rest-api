package mg.java.springbootsearchrestapi.service.impl;

import lombok.Setter;
import mg.java.springbootsearchrestapi.dto.OrderRequest;
import mg.java.springbootsearchrestapi.dto.OrderResponse;
import mg.java.springbootsearchrestapi.entity.Order;
import mg.java.springbootsearchrestapi.entity.Payment;
import mg.java.springbootsearchrestapi.exception.PaymentException;
import mg.java.springbootsearchrestapi.repository.OrderRepository;
import mg.java.springbootsearchrestapi.repository.PaymentRepository;
import mg.java.springbootsearchrestapi.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.PrinterException;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    @Transactional
    public OrderResponse placeOrder(OrderRequest orderRequest) {

        Order order = orderRequest.getOrder();
        order.setStatus("INPROGRESS");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();

        if(!payment.getType().equals("DEBIT")){
            throw new PaymentException("Payment card type not supported");
        }

        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS");
        return orderResponse;
    }
}
