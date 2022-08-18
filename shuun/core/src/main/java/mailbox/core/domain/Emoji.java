package mailbox.core.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Emoji {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emojiIdx;
    @OneToMany(mappedBy = "emoji")
    private List<LetterEmoji> letterEmojis = new ArrayList<>();

    @Column(length = 45, nullable = false)
    private Long emojiName;

    @Column(length = 45, nullable = false)
    private Long emojiUrl;

    @Builder
    public void Emoji(Long emojiIdx, Long emojiName, Long emojiUrl){
        this.emojiIdx = emojiIdx;
        this.emojiName = emojiName;
        this.emojiUrl = emojiUrl;
    }

}
