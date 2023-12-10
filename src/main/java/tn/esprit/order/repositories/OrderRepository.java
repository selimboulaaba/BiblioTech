package tn.esprit.order.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.order.entities.Orders;

import java.util.Date;

public interface OrderRepository extends JpaRepository<Orders,Long> {
    @Query("select o.returnDate from Orders o WHERE o.idBook=:idBook order By o.returnDate DESC LIMIT 1")
    public Date findByIdBook(@Param("idBook")long idBook );


}
