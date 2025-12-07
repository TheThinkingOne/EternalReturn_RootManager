package org.kiye.eternalreturnrootmanagerbackend.domain.character;

import jakarta.persistence.*;
import lombok.*;
import org.kiye.eternalreturnrootmanagerbackend.domain.common.BaseTimeEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "char_skill_ability")
@Builder
// 스킬레벨별 스킬 데미지, 힐량, 보호막량 수치 등등 정하는 엔터티
public class CharSkillAbilityPerLevel extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skill_id", nullable = false)
    private CharSkills skill;

    // 스킬 레벨별 설계
    // 예를들어 사용자가 루트 다 만들고 나서 6레벨이고
    // q 2개, w 1개, e 1개, r 1개, 패시브 1개 찍었다면
    // 현재 캐릭터 스텟에 기반한 2레벨 q스킬 데미지, 1레벨 w 스킬 데미지, 1레벨 e스킬 힐량 혹은 보호막량등
    // 2레벨 패시브 데미지(패시브는 기본적으로 1레벨 들고 시작, 최대 3레벨)
    // 등등을 볼 수 있게 할것

    // 스킬레벨(1~5)
    // 근데 스킬레벨 컬럼이 필요한 이유는?
    @Column(nullable = false)
    private int skillLevel;

    // 스킬의 기본 데미지, 힐량, 보호막량 등
    @Column(nullable = true)
    private Double baseDmg;
    @Column(nullable = true)
    private Double baseShield;
    @Column(nullable = true)
    private Double baseHeal;
    // 더 추가 예정

    // 쿨타임
    @Column(nullable = true)
    private Double cooldown;

    // 자원 소모 스킬(ex: 기력, 집중력, 고통중첩(가넷), 얀 패시브 스택 등)
    @Column(nullable = true) // 이리가 요즘은 소모값 없는게 거의 대부분이니
    private Double resourceCost;

    /*// 이 레벨에서 적용되는 계수들
    @OneToMany(mappedBy = "skillLevel", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<CharSkillScaling> scalings = new ArrayList<>();*/

}
