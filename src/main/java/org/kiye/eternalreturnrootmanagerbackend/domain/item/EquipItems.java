package org.kiye.eternalreturnrootmanagerbackend.domain.item;

import jakarta.persistence.*;
import lombok.*;
import org.kiye.eternalreturnrootmanagerbackend.domain.common.BaseTimeEntity;

import java.time.LocalDateTime;

@Entity
@Table(name = "equip_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EquipItems extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String equipItemName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private EquipItemSlot equipItemSlot;

    // 무기군 분류 위한거
    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private WeaponType weaponType;
    // 루트 제작시 캐릭터 및 무기타입 누르고 이 boolean 통해서
    // 무기 타입 중에 해당 무기군 고르라고 사용할듯
    public boolean isWeapon() {
        return this.equipItemSlot == EquipItemSlot.WEAPON;
    }

    // 아래에 작성한 능력치들은 장비마다 있는것도 있고 없는것도 있고 다 상이하니
    // 컬럼으로 파기보다 하나씩 다 넣어서 리스트로 정보 보내는게 맞을듯

    private double attack; // 장비 기본 공격력
    private double attackPerLevel; // 장비 레벨당 공격력

    private double skillAmplification; // 장비 기본 스증
    private double skillAmplificationPerLevel; // 장비 레벨당 스증

    private double defense; // 장비 방어력

    private double hp; // 장비 기본체력
    private double hpPerLevel; // 장비 레벨당 체력
    private double hpRegen; // 체력재생

    private double moveSpeed; // 장비 이동속도(%)

    private double attackSpeed; // 장비 공격속도

    private double cooldown; // 스킬가속
    private double tacSkillCooldown; // 탭루트 같은거에 있는 전술스킬 쿨다운감소

    private double ccResist; // 방해효과 저항
    private double slowResist; // 둔화효과 저항

    private double critRate; // 치확
    private double critDmg; // 치피

    private double lifeSteal; // 생명력 흡수
    private double omniLifeSteal; // 모든 피해 흡혈

    private double defPierce; // 방어관통
    private double defPercentPierce; // 방어관통(%)

    private double sight; // 추가 시야

    private double basicAttackRange; // 기본 공격 사거리

    private double recoveryIncrease; // 주는 회복 증가

    // 아이템 5개 골랐을때 통상적으로 보는 능력치들
    // EX: 공격력, 체력, 공격속도, 치확, 치피 이속 이런거는 일반 능력치 로 보여주고
    // 특수 능력치 EX: 주는회복증가, 강인함 등등 도 따로 보여주도록 하자



    // 여기서부턴 아이템 고유효과
    private String healReduce40; // 약치감
    private String healReduce60; // 강치감

    private String Reflection; // 리플랙션

    private String flameBarrier; // 태불망 (불꽃결계)
    // => 근데이거 영웅 전설 초월 별로 다 데미지 다른경우가 있음 ㅅㅂ 족같네

    // 치감, 신속, 같은 고유효과도 생각해서 엔터티 해야겠네
    // 치감, 신속, 충전 같은 교유효과 엔터티와 이거 매핑
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unique_effect_id")
    private UniqueEffect uniqueEffect;

}
