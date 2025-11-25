package org.kiye.eternalreturnrootmanagerbackend.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.kiye.eternalreturnrootmanagerbackend.domain.map.lumia.LumiaRegions;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "eternal_return_map")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Log4j2
@Builder
public class ErMapMode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 맵 이름 (예: Lumia Island, Cobalt Protocol)
    @Column(nullable = false, length = 100)
    private String name;

    // EX: Lumia, Cobalt
    @Column(nullable = false, length = 50, unique = true)
    private String code; // 이건뭐 0 1 2 이런식으로 하면 되나?

    // 배틀로얄 / 팀데스매치 구분
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private GameMode mode;

    // 이 맵이 템파밍식 모드인지(지역 털면서 템 만드는거)
    @Column(nullable = false)
    @Builder.Default
    private boolean hasRegions = true;

    @OneToMany(mappedBy = "map")
    @Builder.Default
    private List<LumiaRegions> regions = new ArrayList<>();

    // 루미아 섬같은 배틀로얄 맵인지
    public boolean isBattleRoyale() {
        return this.mode == GameMode.BATTLE_LOYALE;
    }

    // 코발트같은 배틀로얄 맵인지
    public boolean isTeamDeathMatch() {
        return this.mode == GameMode.TEAM_DEATHMATCH;
    }


}
