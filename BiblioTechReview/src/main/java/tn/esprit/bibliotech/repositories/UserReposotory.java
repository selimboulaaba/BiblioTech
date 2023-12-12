package tn.esprit.bibliotech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.bibliotech.entities.client;

public interface UserReposotory extends JpaRepository<client, Long> {

    public client findByUsername(String username);
}
