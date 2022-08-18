package mailbox.core.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mailbox.core.domain.Letter;

@Getter
@NoArgsConstructor
public class LettersSaveRequestDto {
    private String title;
    private String content;
    private Long recipient;

    @Builder
    public LettersSaveRequestDto(String title, String content, Long recipient){
        this.title = title;
        this.content = content;
        this.recipient = recipient;
    }

    public Letter toEntity(){
        return Letter.builder()
                .title(title)
                .content(content)
                .recipient(recipient)
                .build();
    }

}
