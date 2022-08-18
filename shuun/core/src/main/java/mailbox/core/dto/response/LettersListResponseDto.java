package mailbox.core.dto.response;

import mailbox.core.domain.Letter;

public class LettersListResponseDto {
    private Long letterIdx;
    private String title;
    private String content;
    private Long recipient;

    public LettersListResponseDto(Letter entity){
        this.letterIdx = entity.getLetterIdx();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.recipient = entity.getRecipient();
    }
}
