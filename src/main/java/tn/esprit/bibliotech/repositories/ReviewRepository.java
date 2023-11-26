package tn.esprit.bibliotech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.bibliotech.entities.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
