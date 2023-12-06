package tn.esprit.bibliotech.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.bibliotech.entities.ReplyReview;
import tn.esprit.bibliotech.entities.Review;
import tn.esprit.bibliotech.services.ReplyReviewService;
import tn.esprit.bibliotech.services.ReviewService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/review")
@AllArgsConstructor
public class ReviewController {

    private ReviewService reviewService;

    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable long reviewId) {
        Optional<Review> reply = reviewService.getReviewById(reviewId);
        return reply.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Review> saveReview(@RequestBody Review review) {
        Review savedReply = reviewService.saveReview(review);
        return new ResponseEntity<>(savedReply, HttpStatus.CREATED);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable long reviewId) {
        reviewService.deleteReview(reviewId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/book/{idBook}")
    public List<Review> getAllReviewsByBook(@PathVariable long idBook) {
        return reviewService.getByBook(idBook);
    }
}
