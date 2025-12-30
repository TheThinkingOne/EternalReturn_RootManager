package org.kiye.eternalreturnrootmanagerbackend.dto.route;

import org.kiye.eternalreturnrootmanagerbackend.domain.item.WeaponType;
import org.kiye.eternalreturnrootmanagerbackend.dto.item.RequiredCraftItemsDTO;

import java.util.List;

public record RouteResultDTO(
        String mapCode,
        String charCode,
        WeaponType weaponType,
        List<RouteProcedureDTO> routeProcedure,
        List<RequiredCraftItemsDTO> requiredCraftItems
) {
}
