package org.kiye.eternalreturnrootmanagerbackend.dto;

public record CharStatPerLevelDTO(
        int level,
        double hp,
        double atk,
        double def,
        double atkSpd,
        double skillAmp,
        double moveSpeed
        // 기타 능력치들은 인게임 보면서 뭐뭐 있는지 보고 추가해야할듯
) {
}
