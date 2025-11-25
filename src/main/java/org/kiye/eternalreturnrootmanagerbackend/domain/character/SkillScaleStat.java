package org.kiye.eternalreturnrootmanagerbackend.domain.character;

// 스킬 계수들 정리해놓은 ENUM (공격력, 추가공격력, 추가체력, 방어력 등등)
// 스킬 계수가 어떤 스탯에 붙는지 정하는 enum
public enum SkillScaleStat {
    NONE,
    ATTACK_POWER, // 공격력
    ADDITIONAL_ATTACK_POWER, // 추가 공격력
    SKILL_AMPLIFICATION_POWER, // 스증
    ADDITIONAL_SKILL_AMPLIFICATION_POWER, // 추가 스증(있을진 모르겠지만)
    CURRENT_HP, // 현재체력
    MISSING_HP, // 잃은체력
    ADDITIONAL_HP, // 추가 체력
    DEFENSE_POWER, // 방어력
    MOVE_SPEED, // 이동속도
    // 더 추가예정




}
