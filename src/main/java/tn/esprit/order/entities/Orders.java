package tn.esprit.order.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Orders implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idOrder;
    private long idUser;

    private long idBook;
    @Temporal(TemporalType.DATE)
    private Date pickupDate,returnDate;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;




}
