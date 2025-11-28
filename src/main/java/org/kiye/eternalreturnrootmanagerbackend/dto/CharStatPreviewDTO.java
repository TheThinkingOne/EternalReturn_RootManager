package org.kiye.eternalreturnrootmanagerbackend.dto;

import org.kiye.eternalreturnrootmanagerbackend.domain.item.WeaponType;

import java.util.List;

public record CharStatPreviewDTO(
        String charCode,
        WeaponType weaponType,

        // 5,6,7 레벨 기준(주로)
        List<CharStatPerLevelDTO> levelStats,
        // 해당 레벨에서으 스킬 예상 수치(데미지, 쉴드, 회복량 등등)
        List<SkillFigureDTO> skillFigures
) {
}
