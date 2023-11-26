package tn.esprit.bibliotech.interfaces;

import tn.esprit.bibliotech.entities.ReplyReview;

import java.util.List;
import java.util.Optional;

public interface ReplyReviewInterface {

    public List<ReplyReview> getAllReplies();
    public Optional<ReplyReview> getReplyById(long replyId);
    public ReplyReview saveReply(ReplyReview replyReview, long reviewId);
    public ReplyReview saveReplyToReply(ReplyReview replyReview, long reviewId, long replyId);
    public void deleteReply(long replyId);
}
