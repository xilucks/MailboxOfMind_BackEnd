package mailbox.core.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LettersUpdateRequestDto {
    private String title;
    private String content;
    private Long recipientIdx;

    @Builder
    public LettersUpdateRequestDto(String title, String content, Long recipientIdx){
        this.title = title;
        this.content = content;
        this.recipientIdx = recipientIdx;

    }

}
