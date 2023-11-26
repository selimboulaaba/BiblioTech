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

public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUser;
    private String firstName,lastName,email,password;
    private int cin,tel;
    @Enumerated(EnumType.STRING)
    private Role role;
    @ManyToMany(mappedBy = "user")
    private List<Orders> orders;





}
