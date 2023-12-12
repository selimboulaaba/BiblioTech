package tn.esprit.bibliotech.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idUser;
    String username;
    String password;
    String role;

    public client(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
