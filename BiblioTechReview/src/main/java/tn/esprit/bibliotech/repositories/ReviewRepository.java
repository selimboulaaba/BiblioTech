package tn.esprit.bibliotech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.bibliotech.entities.Review;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    public List<Review> findByBookId(long idBook);
}
