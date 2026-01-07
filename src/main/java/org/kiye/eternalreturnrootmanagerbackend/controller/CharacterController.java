package org.kiye.eternalreturnrootmanagerbackend.controller;

import lombok.RequiredArgsConstructor;
import org.kiye.eternalreturnrootmanagerbackend.domain.character.CharInfo;
import org.kiye.eternalreturnrootmanagerbackend.dto.character.CharDetailDTO;
import org.kiye.eternalreturnrootmanagerbackend.dto.character.CharSummaryDTO;
import org.kiye.eternalreturnrootmanagerbackend.repository.CharInfoRepo;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/er_rootmanager/selectchar")
@RequiredArgsConstructor
public class CharacterController {

    private final CharInfoRepo charInfoRepo;

    // 루트 제작시 캐릭터 선택 창 : 전체 캐릭터 목록 보여주기
    @GetMapping
    public List<CharSummaryDTO> getChars() {
        return charInfoRepo.findAll().stream()
                .map(CharSummaryDTO::from)
                .toList();
    }

    @GetMapping("/{charCode}")
    public CharDetailDTO getCharDetail(@PathVariable String charCode) {
        CharInfo charInfo = charInfoRepo.findByCharCode(charCode)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "캐릭터 없음"));

        return CharDetailDTO.from(charInfo);
    }

}
