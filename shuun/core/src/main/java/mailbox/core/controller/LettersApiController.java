package mailbox.core.controller;

import lombok.RequiredArgsConstructor;
import mailbox.core.dto.request.LettersSaveRequestDto;
import mailbox.core.dto.request.LettersUpdateRequestDto;
import mailbox.core.dto.response.LettersResponseDto;
import mailbox.core.service.LettersService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class LettersApiController {

    private final LettersService lettersService;

    @GetMapping("/letters")
    public String index(Model model){
        model.addAttribute("letters", lettersService.findAllDesc());
        return "index";
    }

    @PostMapping("/letters")
    public Long save(@RequestBody LettersSaveRequestDto requestDto){
        return lettersService.save(requestDto);
    }

    @PatchMapping("/letters/{letterIdx}")
    public Long update(@PathVariable Long letterIdx,
                       @RequestBody LettersUpdateRequestDto requestDto){
        return lettersService.update(letterIdx, requestDto);
    }

    @GetMapping("/letters/{letterIdx}")
    public LettersResponseDto findById (@PathVariable Long letterIdx){
        return lettersService.findById(letterIdx);
    }

    @DeleteMapping("/letters/{letterIdx}")
    public Long delete(@PathVariable Long letterIdx){
        lettersService.delete(letterIdx);
        return letterIdx;
    }

}
