package org.kiye.eternalreturnrootmanagerbackend.controller;

import lombok.RequiredArgsConstructor;
import org.kiye.eternalreturnrootmanagerbackend.domain.character.CharInfo;
import org.kiye.eternalreturnrootmanagerbackend.dto.character.CharWithAssetsDTO;
import org.kiye.eternalreturnrootmanagerbackend.repository.CharInfoRepo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/characters")
@RequiredArgsConstructor
public class CharacterTestController {

    private final CharInfoRepo charInfoRepo;

    @GetMapping("/list")
    public List<CharWithAssetsDTO> getAllCharPortrait() {
        return charInfoRepo.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    // 1) characterNum 기반 조회 (외부 API 연동 중심으로)
    @GetMapping("/num/{characterNum}")
    public CharWithAssetsDTO getByNum(@PathVariable Integer characterNum) {
        CharInfo c = charInfoRepo.findByCharacterNum(characterNum)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "캐릭터 없음"));

        return toDto(c);
    }

    // 2) charCode 기반 조회 (내부/관리용)
    @GetMapping("/code/{charCode}")
    public CharWithAssetsDTO getByCode(@PathVariable String charCode) {
        CharInfo c = charInfoRepo.findByCharCode(charCode)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "캐릭터 없음"));

        return toDto(c);
    }

    // 공통 DTO 변환 (프론트 에셋 규칙 반영)
    private CharWithAssetsDTO toDto(CharInfo c) {
        String folder = c.getCharacterNum() + "_" + c.getCharName().toLowerCase();
        String base = "/assets/characters/" + folder;

        Map<String, String> skillIcons = Map.of(
                "Q", base + "/Q.png",
                "W", base + "/W.png",
                "E", base + "/E.png",
                "R", base + "/R.png",
                "P", base + "/P.png"
        );

        return CharWithAssetsDTO.builder()
                .characterNum(c.getCharacterNum())
                .charCode(c.getCharCode())
                .charName(c.getCharName())
                .baseHp(c.getBaseHp())
                .hpPerLevel(c.getHpPerLevel())
                .baseDef(c.getBaseDef())
                .defPerLevel(c.getDefPerLevel())
                .baseAtk(c.getBaseAtk())
                .atkPerLevel(c.getAtkPerLevel())
                .baseAtkSpd(c.getBaseAtkSpd())
                .atkSpdPerLevel(c.getAtkSpdPerLevel())
                .baseAtkRange(c.getBaseAtkRange())
                .skillAmpPerLevel(c.getSkillAmpPerLevel())
                .portraitUrl(base + "/mini.png") // 캐릭터 미니 초상화
                .skillIconUrls(skillIcons)
                .build();
    }
}

