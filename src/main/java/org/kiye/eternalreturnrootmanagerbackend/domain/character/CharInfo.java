package org.kiye.eternalreturnrootmanagerbackend.domain.character;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.kiye.eternalreturnrootmanagerbackend.domain.item.WeaponType;
import org.springframework.retry.annotation.CircuitBreaker;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "char_info")
@NoArgsConstructor
@Log4j2
@Builder
@AllArgsConstructor
public class CharInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String charName;

    // 내부 코드 (예: 'GARNET', 'EMMA' 등) 나중에 외부 API랑 매핑하기 좋음
    @Column(nullable = false, length = 50, unique = true)
    private String charCode;

    // 해당 캐릭터가 사용할 수 있는 무기군 나타내는걸
    // 캐릭터 정보 엔터티 컬럼에서 꺼내는게 맞을까? (이렇게 설계하는게 맞나?)
//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false, length = 20)
//    // 이부분 리스트로 해야할듯, 다무기군 캐릭도 있으니까
//    private WeaponType charWeaponType;

    // 다무기군 캐릭터(알카엠마, 암기엠마 등) 매칭
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "char_weapon_type",
            joinColumns = @JoinColumn(name = "char_id")
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "weapon_type", length = 30)
    @Builder.Default
    private List<WeaponType> weaponTypes = new ArrayList<>();

    // 아래는 캐릭터들이 공통적으로 가지고 있는 기본 능력치들
    private double baseHp; // 기본체력
    private double baseAtk; // 기본공격력
    private double baseDef; // 기본방어력
    private double baseAtkSpd; // 기본공속
    private double baseAtkRange; // 기본공격사거리

    // 성장능력치들
    private double hpPerLevel; // 성장체력
    private double defPerLevel; // 성장방어력
    private double atkPerLevel; // 성장공격력
    private double atkSpdPerLevel; // 성장공속
    private double skillAmpPerLevel; // 성장스증
    // 등등

    // 캐릭터별로 성장 스증이 있는 캐릭, 성장 공격력이 있는 캐릭이 있는데 이거 어떻게 할까
    @OneToMany(mappedBy = "character", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<CharSkills> charSkills = new ArrayList<>();

    //
    // ex 시작체력, 레벨당체력, 레벨당 스증, 레벨당 방어력 등등
    /*// Q W E R, 패시브
    @Column(nullable = false, length = 50)
    private String charSkillName;*/
    // 스킬마다 스킬레벨당 데미지 혹은 보호막량, 치유량 이런거 어떻게 설계하지?

}
