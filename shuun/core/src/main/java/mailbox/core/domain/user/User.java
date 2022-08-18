package mailbox.core.domain.user;

import lombok.*;
import mailbox.core.domain.Message;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import java.io.Serializable;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userIdx;

    @OneToMany(mappedBy = "user")
    private List<Message> messages = new ArrayList<>();

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public User(String name, String email, Role role){
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public User update(String name, String email){
        this.name = name;
        this.email = email;

        return this;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }

}
