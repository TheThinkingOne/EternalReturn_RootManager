package org.kiye.eternalreturnrootmanagerbackend.dto.character;

import lombok.Builder;

import java.util.Map;

@Builder
public record CharWithAssetsDTO(
        Integer characterNum,
        String charCode,
        String charName,
        double baseHp,
        double hpPerLevel,
        double baseDef,
        double defPerLevel,
        double baseAtk,
        double atkPerLevel,
        double baseAtkSpd,
        double atkSpdPerLevel,
        double baseAtkRange,
        double skillAmpPerLevel,
        String portraitUrl,
        Map<String, String> skillIconUrls
) {
}
