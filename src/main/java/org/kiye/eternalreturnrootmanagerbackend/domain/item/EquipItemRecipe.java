package org.kiye.eternalreturnrootmanagerbackend.domain.item;

import jakarta.persistence.*;
import lombok.*;
import org.kiye.eternalreturnrootmanagerbackend.domain.common.BaseTimeEntity;

import java.time.LocalDateTime;

@Entity
@Table(name = "equip_items_recipe")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EquipItemRecipe extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 완성아이템(보라템 위주)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equip_item_id", nullable = false)
    private EquipItems equip_item;

    // 완성템 제작에 필요한 제작재료
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "craft_item_id", nullable = false)
    private CraftItems craftItems;

    // 완성템 제작에 필요한 제작재료 개수
    // 예를들어 어떤 보라템에 원석이 2개 필요할수도 있으니 이런거 따지렴녀
    @Column(nullable = false)
    private int neededCraftItemQuantity;


}
