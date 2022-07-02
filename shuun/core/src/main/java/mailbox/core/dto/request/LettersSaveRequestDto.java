package mailbox.core.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mailbox.core.domain.Letters;

import java.sql.Timestamp;

@Getter
@NoArgsConstructor
public class LettersSaveRequestDto {
    private String title;
    private String content;

    private String name;
    private Timestamp createDate;

    @Builder
    public LettersSaveRequestDto(String title, String content, String name, Timestamp createDate){
        this.title = title;
        this.content = content;
        this.name = name;
        this.createDate = createDate;
    }

    public Letters toEntity(){
        return Letters.builder()
                .title(title)
                .content(content)
                .name(name)
                .build();
    }

}
