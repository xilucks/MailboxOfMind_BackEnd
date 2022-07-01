package mailbox.core.dto.response;

import mailbox.core.domain.Letters;

public class LettersListResponseDto {
    private Long letterIdx;
    private String title;
    private String content;
    private Long recipientIdx;

    public LettersListResponseDto(Letters entity){
        this.letterIdx = entity.getLetterIdx();
        this.title = entity.getTitle();
        this.recipientIdx = entity.getRecipientIdx();
    }
}
