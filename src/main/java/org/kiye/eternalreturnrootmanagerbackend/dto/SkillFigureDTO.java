package org.kiye.eternalreturnrootmanagerbackend.dto;

import org.kiye.eternalreturnrootmanagerbackend.domain.character.SkillKey;

public record SkillFigureDTO(
        SkillKey key,
        int skillLevel, // 스킬 몇개찍었는지 정하기 ex) q2, w1, e1, r1, p1
        double baseFigure,
        double totalFigure
) {
}
