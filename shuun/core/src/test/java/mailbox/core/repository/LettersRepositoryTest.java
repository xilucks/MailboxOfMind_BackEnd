package mailbox.core.repository;

import mailbox.core.domain.Letter;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.*;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LettersRepositoryTest {

    @Autowired
    LettersRepository lettersRepository;

    @After
    public void cleanup(){
        lettersRepository.deleteAll();
    }

    @Test
    public void 편지저장_불러오기(){

        //given
        String title = "편지 제목";
        String content = "편지 내용";
        Long recipientIdx = 1L;

        lettersRepository.save(Letter.builder()
                .title(title)
                .content(content)
                .recipient(1L)
                .build()
        );

        //when
        List<Letter> lettersList = lettersRepository.findAll();


        //then
        Letter letters = lettersList.get(0);
        Assertions.assertThat(letters.getTitle()).isEqualTo(title);
        Assertions.assertThat(letters.getContent()).isEqualTo(content);
    }

}
