package tn.esprit.order.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.order.entities.Orders;

public interface OrderRepository extends JpaRepository<Orders,Long> {
}
