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
    private String name;

    @Builder
    public Letters(String title, String content, String name){
        this.title = title;
        this.content = content;
        this.name = name;

    }

    public void update(String title, String content, String name){
        this.title = title;
        this.content = content;
        this.name = name;
    }


}
