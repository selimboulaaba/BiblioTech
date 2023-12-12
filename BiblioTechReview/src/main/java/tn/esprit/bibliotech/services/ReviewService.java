package tn.esprit.bibliotech.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.bibliotech.entities.ReplyReview;
import tn.esprit.bibliotech.entities.Review;
import tn.esprit.bibliotech.interfaces.ReviewInterface;
import tn.esprit.bibliotech.repositories.ReplyReviewRepository;
import tn.esprit.bibliotech.repositories.ReviewRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReviewService implements ReviewInterface {

    private ReviewRepository reviewRepository;
    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Optional<Review> getReviewById(long reviewId) {
        return reviewRepository.findById(reviewId);
    }

    @Override
    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public void deleteReview(long reviewId) {
        reviewRepository.deleteById(reviewId);
    }

    @Override
    public List<Review> getByBook(long idBook) {
        return reviewRepository.findByBookId(idBook);
    }
}
