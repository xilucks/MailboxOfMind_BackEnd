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

    private String name;

    @Builder
    public LettersSaveRequestDto(String title, String content, String name){
        this.title = title;
        this.content = content;
        this.name = name;
    }

    public Letters toEntity(){
        return Letters.builder()
                .title(title)
                .content(content)
                .name(name)
                .build();
    }

}
