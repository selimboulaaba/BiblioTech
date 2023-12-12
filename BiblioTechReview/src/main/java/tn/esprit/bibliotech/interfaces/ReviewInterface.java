package tn.esprit.bibliotech.interfaces;

import tn.esprit.bibliotech.entities.ReplyReview;
import tn.esprit.bibliotech.entities.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewInterface {

    public List<Review> getAllReviews();
    public Optional<Review> getReviewById(long reviwId);
    public Review saveReview(Review review);
    public void deleteReview(long reviwId);
    public List<Review> getByBook(long idBook);
}
