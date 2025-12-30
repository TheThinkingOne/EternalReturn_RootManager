package org.kiye.eternalreturnrootmanagerbackend.dto.item;

import org.kiye.eternalreturnrootmanagerbackend.domain.item.EquipItemSlot;
import org.kiye.eternalreturnrootmanagerbackend.domain.item.WeaponType;

public record EquipItemOptionDTO(
        Long id,
        String equipItemName,
        EquipItemSlot equipItemSlot,
        WeaponType weaponType, // 무기인
        String UniqueEffectName,
        String uniqueEffectCode // 이건 필요 없을거같기도한데
) {



}
