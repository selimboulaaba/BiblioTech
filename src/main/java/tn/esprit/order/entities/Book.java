package tn.esprit.order.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBook;
    private String title,auther;
    private Boolean available;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @OneToMany(mappedBy = "book")
    private List<Orders> orders;

}
