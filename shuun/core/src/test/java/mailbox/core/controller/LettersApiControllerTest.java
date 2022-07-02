package mailbox.core.controller;

import mailbox.core.domain.Letters;
import mailbox.core.dto.request.LettersSaveRequestDto;
import mailbox.core.repository.LettersRepository;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LettersApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private LettersRepository lettersRepository;

    @After
    public void tearDown() throws Exception{
        lettersRepository.deleteAll();
    }

//    @Test
//    public void 등록() throws Exception{
//        //given
//        String title = "title";
//        String content = "content";
//        Long recipientIdx = 1L;
//        LettersSaveRequestDto requestDto = LettersSaveRequestDto.builder()
//                .title(title)
//                .content(content)
//                .recipientIdx(recipientIdx)
//                .build();
//
//        String url = "http://localhost:" + port + "/letters";
//
//        //when
//        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);
//
//        //then
//        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//        Assertions.assertThat(responseEntity.getBody()).isGreaterThan(0L);
//
//
//        List<Letters> all = lettersRepository.findAll();
//        Assertions.assertThat(all.get(0).getTitle()).isEqualTo(title);
//        Assertions.assertThat(all.get(0).getContent()).isEqualTo(content);
//    }

}