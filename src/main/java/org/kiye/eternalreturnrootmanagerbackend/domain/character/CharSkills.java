package org.kiye.eternalreturnrootmanagerbackend.domain.character;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "char_skills")
@Builder
public class CharSkills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 어느 캐릭터의 스킬인지 연결
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "char_id", nullable = false)
    private CharInfo character;

    // Q W E R 패시브 스킬
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private SkillKey key;
    // 스킬 설명
    @Column(nullable = false, length = 1000)
    private String description;

    // 레벨별 수치(기본데미지, 힐량, 쉴드량, 쿨타임 등)
    @OneToMany(mappedBy = "skill", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<CharSkillAbilityPerLevel> levels = new ArrayList<>();

    // 이 스킬의 계수들(단일계수이든, 얀 처럼 복합계수이든)
    // 이 스킬의 모든 계수(ex 얀의 q스킬은 공격력계수, 스증계수, 대상의 최대체력 계수가 같이 있다)
    @OneToMany(mappedBy = "skill", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<CharSkillScaling> scalings = new ArrayList<>();

}
