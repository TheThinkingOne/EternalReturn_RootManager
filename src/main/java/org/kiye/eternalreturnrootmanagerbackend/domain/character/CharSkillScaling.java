package org.kiye.eternalreturnrootmanagerbackend.domain.character;

import jakarta.persistence.*;
import lombok.*;
import org.kiye.eternalreturnrootmanagerbackend.domain.common.BaseTimeEntity;

import java.time.LocalDateTime;

// 다계수 스킬 가진 캐릭터를 위한 엔터티
@Entity
@Getter @Setter
@Table(name = "char_skill_scaling")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CharSkillScaling extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 어느 스킬에 붙는 계수인지 (Q W E R 패시브)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "skill_id")
    private CharSkills skill;

    // 어떤 스탯에 비례하는지 (공격력, 스증, 최대 체력 등)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private SkillScaleStat stat;

    // 계수 비율 (공격력 80%면 0.8, 최대 체력 6%면 0.06)
    @Column(nullable = false)
    private double ratio;

}
