package org.kiye.eternalreturnrootmanagerbackend.dto;

import org.kiye.eternalreturnrootmanagerbackend.domain.character.CharInfo;
import org.kiye.eternalreturnrootmanagerbackend.domain.item.WeaponType;

import java.util.List;

public record CharDetailDTO(
        Long id,
        String charName,
        String charCode,
        List<WeaponType> weaponTypes
) {
    public static CharDetailDTO from(CharInfo charInfo) {
        return new CharDetailDTO(
                charInfo.getId(),
                charInfo.getCharName(),
                charInfo.getCharCode(),
                charInfo.getWeaponTypes()
        );
    }
}
