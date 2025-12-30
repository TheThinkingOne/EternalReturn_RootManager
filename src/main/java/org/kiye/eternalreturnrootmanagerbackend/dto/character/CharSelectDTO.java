package org.kiye.eternalreturnrootmanagerbackend.dto.character;

import org.kiye.eternalreturnrootmanagerbackend.domain.item.WeaponType;

import java.util.List;

public record CharSelectDTO(String charCode,
                            String charName,
                            List<WeaponType> weaponTypes) {
    // record 는 뭐지?
}
