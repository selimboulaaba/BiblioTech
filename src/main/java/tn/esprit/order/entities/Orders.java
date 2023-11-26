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
    @ManyToMany
    private List<User> user;
    @ManyToOne
    private Book book;
    @Temporal(TemporalType.DATE)
    private Date pickupDate,returnDate;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;




}
