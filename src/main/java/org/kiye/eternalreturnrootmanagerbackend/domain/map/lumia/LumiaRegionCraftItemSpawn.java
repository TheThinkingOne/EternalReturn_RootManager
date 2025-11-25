package org.kiye.eternalreturnrootmanagerbackend.domain.map.lumia;

import jakarta.persistence.*;
import lombok.*;
import org.kiye.eternalreturnrootmanagerbackend.domain.item.CraftItems;

@Entity
@Table(name = "lumia_region_craft_spawn")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
// 루미아섬 지역별 아이템 나오는 거 작성하는 엔티티
public class LumiaRegionCraftItemSpawn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id", nullable = false)
    private LumiaRegions lumiaRegions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "craft_item_id", nullable = false)
    private CraftItems craftItems;


}
