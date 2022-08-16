package mailbox.core.dto.response;

import lombok.Getter;
import mailbox.core.domain.Letters;

@Getter
public class LettersResponseDto {
    private Long letterIdx;
    private String title;
    private String content;
    private Long recipientIdx;

    public LettersResponseDto(Letters entity){
        this.letterIdx = entity.getLetterIdx();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.recipientIdx = entity.getRecipientIdx();
    }
}
