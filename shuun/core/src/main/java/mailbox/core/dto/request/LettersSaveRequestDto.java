package mailbox.core.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mailbox.core.domain.Letters;

@Getter
@NoArgsConstructor
public class LettersSaveRequestDto {
    private String title;
    private String content;
    private Long recipientIdx;

    @Builder
    public LettersSaveRequestDto(String title, String content, Long recipientIdx){
        this.title = title;
        this.content = content;
        this.recipientIdx = recipientIdx;
    }

    public Letters toEntity(){
        return Letters.builder()
                .title(title)
                .content(content)
                .recipientIdx(recipientIdx)
                .build();
    }

}
