package org.kiye.eternalreturnrootmanagerbackend.dto;

import org.kiye.eternalreturnrootmanagerbackend.domain.item.EquipItemSlot;
import org.kiye.eternalreturnrootmanagerbackend.domain.item.WeaponType;

import java.util.List;
import java.util.Map;

// 캐릭터 및 무기군 고른 후 사용자가 선택할 수 있는 DTO
public record ItemSelectResponseDTO(
        WeaponType weaponType,
        Map<EquipItemSlot, List<EquipItemDTO>> itemsBySlot
) {
}
