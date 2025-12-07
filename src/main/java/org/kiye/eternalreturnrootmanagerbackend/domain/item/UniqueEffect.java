package org.kiye.eternalreturnrootmanagerbackend.domain.item;

import jakarta.persistence.*;
import lombok.*;
import org.kiye.eternalreturnrootmanagerbackend.domain.common.BaseTimeEntity;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@Table(name = "item_unique_effect")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UniqueEffect extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ex: WEAK_HEAL_REDUCTION, PASSION
    @Column(nullable = false, length = 50, unique = true)
    private String code;

    // ex: 약한 치유 감소, 열정, 신속, 충전-섬광, 연장 총열 등등
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, length = 500)
    private String description; // 고유효과 설명텍스트


    // 설명텍스트
    @Column(nullable = false, length = 500)
    private String uniqueEffectDescription;

}
