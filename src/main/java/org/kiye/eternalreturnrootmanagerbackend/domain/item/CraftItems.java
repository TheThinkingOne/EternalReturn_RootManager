package org.kiye.eternalreturnrootmanagerbackend.domain.item;

import jakarta.persistence.*;
import lombok.*;
import org.kiye.eternalreturnrootmanagerbackend.domain.common.BaseTimeEntity;

import java.time.LocalDateTime;

@Entity
@Table(name = "craft_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CraftItems extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String craftItemName;

    // 희귀도는 신경안쓸듯 사실 신경쓸필요 없음
}
