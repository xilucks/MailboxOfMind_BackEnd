package mailbox.core.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LettersUpdateRequestDto {
    private String title;
    private String content;
    private String name;

    @Builder
    public LettersUpdateRequestDto(String title, String content, String name){
        this.title = title;
        this.content = content;
        this.name = name;

    }

}
