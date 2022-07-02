package mailbox.core.dto.response;

import lombok.Data;
import mailbox.core.domain.Letters;

import java.sql.Timestamp;

@Data
public class LettersListResponseDto {
    private Long letterIdx;
    private String title;
    private String content;
    private String name;
    private Timestamp createDate;

    public LettersListResponseDto(Letters entity){
        this.letterIdx = entity.getLetterIdx();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.name = entity.getName();
        this.createDate = Timestamp.valueOf(entity.getCreateDate());
    }
}
