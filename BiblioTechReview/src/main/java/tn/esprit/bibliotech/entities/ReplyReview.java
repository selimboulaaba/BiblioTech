package tn.esprit.bibliotech.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReplyReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long replyId;
    @ManyToOne
    @JsonIgnore
    Review parentReview;
    long userId;
    @ManyToOne
    @JsonIgnore
    ReplyReview parentReply;
    @OneToMany(mappedBy = "parentReply")
    List<ReplyReview> childReplies;
    String comment;
    LocalDateTime date;

    public ReplyReview(Review parentReview, long userId, ReplyReview parentReply, List<ReplyReview> childReplies, String comment, LocalDateTime date) {
        this.parentReview = parentReview;
        this.userId = userId;
        this.parentReply = parentReply;
        this.childReplies = childReplies;
        this.comment = comment;
        this.date = date;
    }
}
