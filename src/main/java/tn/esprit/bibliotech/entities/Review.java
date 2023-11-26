package tn.esprit.bibliotech.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

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
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long reviewId;
    long userId;
    long bookId;
    @OneToMany(mappedBy = "parentReview", cascade = CascadeType.REMOVE)
    List<ReplyReview> childreplies;
    int rating;
    String comment;
    LocalDateTime date;

    public Review(long userId, long bookId, int rating, String comment, LocalDateTime date) {
        this.userId = userId;
        this.bookId = bookId;
        this.rating = rating;
        this.comment = comment;
        this.date = date;
    }
}
