package mailbox.core.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Present {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long presentIdx;

    @ManyToOne
    @JoinColumn(name="letterIdx")
    private Letter letter;

    @Column(length = 45, nullable = false)
    private Long letterIdx;

    @Column(length = 45, nullable = false)
    private Long presentName;

    @Column(length = 500, nullable = false)
    private Long presentUrl;


    @Builder
    public void Present(Long presentName, Long presentUrl){
        this.presentName = presentName;
        this.presentUrl = presentUrl;
    }

}
