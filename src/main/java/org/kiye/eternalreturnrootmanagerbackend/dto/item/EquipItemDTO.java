package org.kiye.eternalreturnrootmanagerbackend.dto.item;

import org.kiye.eternalreturnrootmanagerbackend.domain.item.EquipItemSlot;
import org.kiye.eternalreturnrootmanagerbackend.domain.item.EquipItems;
import org.kiye.eternalreturnrootmanagerbackend.domain.item.WeaponType;

public record EquipItemDTO(
        Long id,

        // 이름과 장비 슬롯
        String equipItemName,
        EquipItemSlot equipItemSlot,

        // 무기인 경우 무기타입 불러와야해서
        WeaponType weaponType,

        // 수많은 기본 스텟들 어떻게 해야할지 감이 안온다......
        // 일단 기본적인 스텟들 적어봄
        // 공격력, 레벨당공격력, 스증, 레벨당스증, 체력, 레벨당체력, 공속, 치확, 치피, 쿨감 정도
        double attack,
        double attackPerLevel,
        double skillAmplification,
        double skillAmplificationPerLevel,
        double hp,
        double hpPerLevel,
        double defense,

        // 유틸
        double attackSpeed,
        double moveSpeed,
        double cooldown,

        // 치명타 관련
        double critRate, // 치확
        double critDmg, // 치피

        // 고유효과는 이름정도만 (목록에서는 툴팁 간단 표시용)
        String uniqueEffectName

) {
    public static EquipItemDTO from(EquipItems items) {
        return new EquipItemDTO(
                items.getId(),
                items.getEquipItemName(),
                items.getEquipItemSlot(),
                items.getWeaponType(),
                items.getAttack(),
                items.getAttackPerLevel(),
                items.getSkillAmplification(),
                items.getSkillAmplificationPerLevel(),
                items.getHp(),
                items.getHpPerLevel(),
                items.getDefense(),
                items.getAttackSpeed(),
                items.getMoveSpeed(),
                items.getCooldown(),
                items.getCritRate(),
                items.getCritDmg(),
                items.getUniqueEffect() != null ? items.getUniqueEffect().getName() : null
        );
    }
}
