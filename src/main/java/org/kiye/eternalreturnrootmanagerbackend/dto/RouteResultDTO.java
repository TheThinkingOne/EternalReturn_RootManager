package org.kiye.eternalreturnrootmanagerbackend.dto;

import org.kiye.eternalreturnrootmanagerbackend.domain.item.WeaponType;

import java.util.List;

public record RouteResultDTO(
        String mapCode,
        String charCode,
        WeaponType weaponType,
        List<RouteProcedureDTO> routeProcedure,
        List<RequiredCraftItemsDTO> requiredCraftItems
) {
}
