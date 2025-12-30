package org.kiye.eternalreturnrootmanagerbackend.dto.route;

import org.kiye.eternalreturnrootmanagerbackend.domain.item.WeaponType;

public record RouteBuildRequestDTO(
        String mapCode,
        String charCode,
        WeaponType weaponType,
        Long weaponItemId,
        Long headItemId,
        Long chestItemId,
        Long armItemId,
        Long legItemId
        // 추후에 특성도 추가
) {
}
