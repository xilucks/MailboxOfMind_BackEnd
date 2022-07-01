package mailbox.core.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Recipient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recipientIdx;

    @Column(length = 45, nullable = false)
    private String name;

    @Builder
    public Recipient(String name){
        this.name = name;
    }
}
