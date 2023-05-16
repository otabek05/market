package main.market.Repository;

import main.market.Entity.PaymentList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<PaymentList, Long> {
}
