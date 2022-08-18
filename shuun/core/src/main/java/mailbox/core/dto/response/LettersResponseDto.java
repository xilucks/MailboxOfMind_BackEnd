package mailbox.core.dto.response;

import lombok.Getter;
import mailbox.core.domain.Letter;

@Getter
public class LettersResponseDto {
    private Long letterIdx;
    private String title;
    private String content;
    private Long recipient;

    public LettersResponseDto(Letter entity){
        this.letterIdx = entity.getLetterIdx();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.recipient = entity.getRecipient();
    }
}
