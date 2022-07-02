package mailbox.core.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Getter
@RequiredArgsConstructor
@Entity
public class Letters {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long letterIdx;

    @Column(length = 45, nullable = false)
    private String title;

    @Column(length = 1000, nullable = false)
    private String content;

    @Column(nullable = false)
    private Long recipientIdx;

    @Builder
    public Letters(String title, String content, Long recipientIdx){
        this.title = title;
        this.content = content;
        this.recipientIdx = recipientIdx;

    }

    public void update(String title, String content, Long recipientIdx){
        this.title = title;
        this.content = content;
        this.recipientIdx = recipientIdx;
    }


}
