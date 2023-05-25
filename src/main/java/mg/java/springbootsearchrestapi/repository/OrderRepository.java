package mg.java.springbootsearchrestapi.repository;

import mg.java.springbootsearchrestapi.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
