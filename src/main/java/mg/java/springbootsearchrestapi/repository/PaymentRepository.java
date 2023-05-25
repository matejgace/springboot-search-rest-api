package mg.java.springbootsearchrestapi.repository;

import mg.java.springbootsearchrestapi.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
