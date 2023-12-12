package tn.esprit.bibliotech.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.bibliotech.entities.ReplyReview;
import tn.esprit.bibliotech.interfaces.ReplyReviewInterface;
import tn.esprit.bibliotech.repositories.ReplyReviewRepository;
import tn.esprit.bibliotech.repositories.ReviewRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReplyReviewService implements ReplyReviewInterface {

    private ReplyReviewRepository replyReviewRepository;
    private ReviewRepository reviewRepository;

    @Override
    public List<ReplyReview> getAllReplies() {
        return replyReviewRepository.findAll();
    }

    @Override
    public Optional<ReplyReview> getReplyById(long replyId) {
        return replyReviewRepository.findById(replyId);
    }

    @Override
    public ReplyReview saveReply(ReplyReview replyReview, long reviewId) {
        replyReview.setParentReview(reviewRepository.findById(reviewId).get());
        return replyReviewRepository.save(replyReview);
    }

    @Override
    public ReplyReview saveReplyToReply(ReplyReview replyReview, long replyId) {
        replyReview.setParentReply(replyReviewRepository.findById(replyId).get());
        return replyReviewRepository.save(replyReview);
    }

    @Override
    public void deleteReply(long replyId) {
        replyReviewRepository.deleteById(replyId);
    }
}
