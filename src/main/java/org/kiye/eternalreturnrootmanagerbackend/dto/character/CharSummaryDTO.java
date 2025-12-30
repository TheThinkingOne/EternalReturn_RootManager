package org.kiye.eternalreturnrootmanagerbackend.dto.character;


import org.kiye.eternalreturnrootmanagerbackend.domain.character.CharInfo;

public record CharSummaryDTO(
        Long id,
        String charName,
        String charCode
        //String portraitUrl // 캐릭터 초상화 이미지 경로, 이건 나중에 어떻게 할지 다시 생각해봐야
) {
    public static CharSummaryDTO from(CharInfo charInfo) {
        return new CharSummaryDTO(
                charInfo.getId(),
                charInfo.getCharName(),
                charInfo.getCharCode()
        );
    }
}
