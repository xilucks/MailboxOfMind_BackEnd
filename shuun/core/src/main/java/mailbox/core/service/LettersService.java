package mailbox.core.service;

import lombok.RequiredArgsConstructor;
import mailbox.core.domain.Letters;
import mailbox.core.dto.request.LettersUpdateRequestDto;
import mailbox.core.dto.request.LettersSaveRequestDto;
import mailbox.core.dto.response.LettersListResponseDto;
import mailbox.core.dto.response.LettersResponseDto;
import mailbox.core.repository.LettersRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class LettersService {
    private final LettersRepository lettersRepository;

    @Transactional
    public Long save(LettersSaveRequestDto requestDto){
        return lettersRepository.save(requestDto.toEntity()).getLetterIdx();
    }

    @Transactional
    public Long update(Long letterIdx, LettersUpdateRequestDto requestDto){
        Letters letters = lettersRepository.findById(letterIdx).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글을 찾을 수 없습니다. id = " + letterIdx));

        letters.update(requestDto.getTitle(), requestDto.getContent(), requestDto.getName());
        System.out.println("생성 : " + letters.getCreateDate());
        System.out.println("수정 : " + letters.getUpdateDate());

        return letterIdx;
    }

    public LettersResponseDto findById(Long letterIdx){
        Letters entity = lettersRepository.findById(letterIdx).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글을 찾을 수 없습니다. id = " + letterIdx));
        System.out.println("생성 : " + entity.getCreateDate());
        return new LettersResponseDto(entity);

    }

    @Transactional
    public List<LettersListResponseDto> findAllDesc(){
        return lettersRepository.findAllDesc().stream()
                .map(LettersListResponseDto::new)
                .collect(Collectors.toList());
    }


    @Transactional
    public void delete(Long letterIdx){
        Letters letters = lettersRepository.findById(letterIdx)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글을 찾을 수 없습니다 id: " + letterIdx));

        lettersRepository.delete(letters);
    }




}
