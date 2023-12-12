package tn.esprit.bibliotech.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.bibliotech.entities.ReplyReview;
import tn.esprit.bibliotech.services.ReplyReviewService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reply")
@AllArgsConstructor
public class ReplyReviewController {

    private ReplyReviewService replyReviewService;

    @GetMapping
    public List<ReplyReview> getAllReplies() {
        return replyReviewService.getAllReplies();
    }

    @GetMapping("/{replyId}")
    public ResponseEntity<ReplyReview> getReplyById(@PathVariable long replyId) {
        Optional<ReplyReview> reply = replyReviewService.getReplyById(replyId);
        return reply.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/{reviewId}")
    public ResponseEntity<ReplyReview> saveReply(@PathVariable long reviewId, @RequestBody ReplyReview replyReview) {
        ReplyReview savedReply = replyReviewService.saveReply(replyReview, reviewId);
        return new ResponseEntity<>(savedReply, HttpStatus.CREATED);
    }

    @PostMapping("/{reviewId}/{replyId}")
    public ResponseEntity<ReplyReview> saveReplytoReply(@PathVariable long reviewId, @PathVariable long replyId, @RequestBody ReplyReview replyReview) {
        ReplyReview savedReply = replyReviewService.saveReplyToReply(replyReview, replyId);
        return new ResponseEntity<>(savedReply, HttpStatus.CREATED);
    }

    @DeleteMapping("/{replyId}")
    public ResponseEntity<Void> deleteReply(@PathVariable long replyId) {
        replyReviewService.deleteReply(replyId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
