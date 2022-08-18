package mailbox.core.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
@Entity
public class Letter extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long letterIdx;

    @Column(length = 45, nullable = false)
    private Long userIdx;

    @Column(length = 45, nullable = false)
    private Long recipient;

    @OneToMany(mappedBy = "letter")
    private List<Present> presents = new ArrayList<>();

    @OneToMany(mappedBy = "letter")
    private List<LetterEmoji> letterEmojis = new ArrayList<>();

    @OneToMany(mappedBy = "letter")
    private List<LetterTag> letterTags = new ArrayList<>();

    @OneToMany(mappedBy = "letter")
    private List<Message> messages = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="userIdx")
    private User user;

    @Column(length = 45, nullable = false)
    private String title;

    @Column(length = 1000, nullable = false)
    private String content;

    @Column(length = 45, nullable = false)
    private String sender;

    @Column(length = 45, nullable = false)
    private String destination;

    @Column(length = 10, nullable = false)
    private String presentStatus;

    @Column(length = 10, nullable = false)
    private String status;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createDate;


    @Builder
    public Letter(String title, String content, String sender, Long recipient, String destination, String presentStatus){
        this.title = title;
        this.content = content;
        this.sender = sender;
        this.recipient = recipient;
        this.destination = destination;
        this.presentStatus = presentStatus;

    }

    public void update(String title, String content, String name){
        this.title = title;
        this.content = content;
    }

}
