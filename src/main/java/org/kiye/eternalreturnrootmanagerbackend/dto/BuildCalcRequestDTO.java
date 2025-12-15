package org.kiye.eternalreturnrootmanagerbackend.dto;

import org.kiye.eternalreturnrootmanagerbackend.domain.item.WeaponType;

import java.util.List;

public record BuildCalcRequestDTO(
        String charCode,
        WeaponType weaponType,
        List<Long> equipItemIds,
        List<Integer> levels
) {
}
