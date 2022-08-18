package mailbox.core.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class LetterEmoji {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long letterIdx;
    @ManyToOne
    @JoinColumn(name="emojiIdx")
    private Emoji emoji;

    @ManyToOne
    @JoinColumn(name="letterIdx")
    private Letter letter;

    @Column(length = 45, nullable = false)
    private Long emojiIdx;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createDate;

    @Builder
    public void LetterEmoji(Long letterIdx, Long emojiIdx){
        this.letterIdx = letterIdx;
        this.emojiIdx = emojiIdx;
    }


}
