package org.kiye.eternalreturnrootmanagerbackend.domain.map.lumia;

import jakarta.persistence.*;
import lombok.*;
import org.kiye.eternalreturnrootmanagerbackend.domain.common.BaseTimeEntity;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@Table(name = "lumia_region_animal_spawn")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LumiaRegionAnimalSpawn extends BaseTimeEntity {

    // 루트 설정하고 마지막 루트에서 1일차에 파밍할 수 있는
    // 야생동물 보여주기 위한 엔터티
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id", nullable = false)
    private LumiaRegions lumiaRegions;

    @Column(nullable = false, length = 50)
    private String animalName;

    @Column(nullable = false)
    private int count;


}
