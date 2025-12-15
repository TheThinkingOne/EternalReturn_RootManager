package org.kiye.eternalreturnrootmanagerbackend.controller;

import lombok.RequiredArgsConstructor;
import org.kiye.eternalreturnrootmanagerbackend.domain.character.CharInfo;
import org.kiye.eternalreturnrootmanagerbackend.dto.CharDetailDTO;
import org.kiye.eternalreturnrootmanagerbackend.dto.CharSummaryDTO;
import org.kiye.eternalreturnrootmanagerbackend.repository.CharInfoRepo;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/erRootManager/characters")
@RequiredArgsConstructor
public class CharacterController {

    private final CharInfoRepo charInfoRepo;

    @GetMapping
    public List<CharSummaryDTO> getChars() {
        return charInfoRepo.findAll().stream()
                .map(CharSummaryDTO::from)
                .toList();
    }

    @GetMapping("/{charCode}")
    public CharDetailDTO getCharDetail(@PathVariable String charCode) {
        CharInfo charInfo = charInfoRepo.findByCharCode(charCode)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException("캐릭터 없음"));

        return CharDetailDTO.from(charInfo);
    }

}
