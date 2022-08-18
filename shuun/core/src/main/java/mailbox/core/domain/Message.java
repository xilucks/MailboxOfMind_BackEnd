package mailbox.core.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import mailbox.core.domain.user.User;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
@Entity
public class Message extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageIdx;

    @Column(length = 45,insertable = false, updatable = false, nullable = false)
    private Long senderIdx;

    @Column(length = 45, nullable = false)
    private Long recipientIdx;

    @Column(length = 45,insertable = false, updatable = false ,nullable = false)
    private Long letterIdx;

    @ManyToOne
    @JoinColumn(name="senderIdx")
    private User user;

    @ManyToOne
    @JoinColumn(name="letterIdx")
    private Letter letter;

    @Column(length = 45, nullable = false)
    private Long content;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createDate;

    @Column(length = 10, nullable = false)
    private String status;

    @Builder
    public Message(Long recipientIdx, Long letterIdx, Long content){
        this.recipientIdx = recipientIdx;
        this.letterIdx = letterIdx;
        this.content = content;
    }
}