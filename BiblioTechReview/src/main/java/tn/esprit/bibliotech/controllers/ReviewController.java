package tn.esprit.bibliotech.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.bibliotech.entities.ReplyReview;
import tn.esprit.bibliotech.entities.Review;
import tn.esprit.bibliotech.services.ReplyReviewService;
import tn.esprit.bibliotech.services.ReviewService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/review")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ReviewController {

    private ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = reviewService.getAllReviews();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @GetMapping("/post")
    public ResponseEntity<Review> saveReview(@RequestParam(name = "userId") long userId, @RequestParam(name = "bookId") long bookId, @RequestParam(name = "comment") String comment) {
        Review review = new Review(userId, bookId, 5, comment, LocalDateTime.now());
        Review savedReply = reviewService.saveReview(review);
        return new ResponseEntity<>(savedReply, HttpStatus.CREATED);
    }
    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable long reviewId) {
        Optional<Review> reply = reviewService.getReviewById(reviewId);
        return reply.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
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
