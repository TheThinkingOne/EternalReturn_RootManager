package org.kiye.eternalreturnrootmanagerbackend.domain.map.lumia;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.kiye.eternalreturnrootmanagerbackend.domain.ErMapMode;

import java.util.ArrayList;
import java.util.List;

// 루미아 섬 지역들
@Entity
@Getter @Setter
@Table(name = "lumia_regions")
@NoArgsConstructor
@Log4j2
@Builder
@AllArgsConstructor
// 루미아 섬 지역 엔티티
public class LumiaRegions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // EX: 성당, 골목길, 항구 등
    @Column(nullable = false, length = 100)
    private String name;

    // EX: CHURCH, ALLEY, HARBOR 등
    @Column(nullable = false, length = 50, unique = true)
    private String code;

    // 맵 모드랑 이거랑 상관이 있나? 루트제작인데
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "map_id", nullable = false)
    private ErMapMode map;

    // 어느지역에 무슨 제작템이 있는지 만들기 위해 LumiaRegionCraftItemSpawn 과 연결
    @OneToMany(mappedBy = "region")
    @Builder.Default
    private List<LumiaRegionCraftItemSpawn> spawnItems = new ArrayList<>();

    // 해댱 지역에 하이퍼루트 있는지 여부 확인 boolean
    @Column(nullable = false)
    @Builder.Default
    private boolean hasHyperLoof = false;

    // 이 지역에서 나가는 엣지들 (한칸 옆동네 인접 지역 정보)
    @OneToMany(mappedBy = "fromRegion")
    @Builder.Default
    private List<LumiaRegionEdge> outgoingEdges = new ArrayList<>();

    // 해당 지역에 인접한 지역이 어디 있는지도 봐야함
    /*@Column(nullable = false)
    private List*/

    // 아이템 개수는 필요없을듯

    // 지역 내에 야생동물 뭐뭐 나오는지 그냥 여기에 써놓는게 나을듯(1일차아침, 밤 기준)


}
