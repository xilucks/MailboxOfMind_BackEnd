package mailbox.core.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class LetterTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long letterIdx;

    @ManyToOne
    @JoinColumn(name="tagIdx2")
    private Tag tag;

    @ManyToOne
    @JoinColumn(name="letterIdx2")
    private Letter letter;

    @Column(length = 45, nullable = false)
    private Long tagIdx;

    @Builder
    public void LetterTag(Long letterIdx, Long tagIdx){
        this.letterIdx = letterIdx;
        this.tagIdx = tagIdx;
    }

}
