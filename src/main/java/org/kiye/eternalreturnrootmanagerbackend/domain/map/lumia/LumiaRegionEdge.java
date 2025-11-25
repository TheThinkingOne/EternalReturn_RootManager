package org.kiye.eternalreturnrootmanagerbackend.domain.map.lumia;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "lumia_region_edge")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LumiaRegionEdge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 출발 지역
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_region_id", nullable = false)
    private LumiaRegions fromRegion;

    // 도착 지역
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_region_id", nullable = false)
    private LumiaRegions toRegion;

    // 이동 경로 타입 (보통 이동 / 하이퍼루프)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private LumiaRegionEdgeType edgeType;

    // (옵션) 이동 거리나 시간 비용 – 나중에 A*, Dijkstra 쓸 때 사용
    @Column(nullable = false)
    @Builder.Default
    private int cost;

}
