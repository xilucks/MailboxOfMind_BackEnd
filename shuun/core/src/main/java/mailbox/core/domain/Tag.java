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
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagIdx;
    @OneToMany(mappedBy = "tag")
    private List<LetterTag> letterTags = new ArrayList<>();

    @Column(length = 45, nullable = false)
    private Long tagName;

    @Builder
    public Tag (Long tagIdx, Long tagName){
        this.tagIdx = tagIdx;
        this.tagName = tagName;
    }

}
