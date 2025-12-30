package org.kiye.eternalreturnrootmanagerbackend.controller;

import lombok.RequiredArgsConstructor;
import org.kiye.eternalreturnrootmanagerbackend.domain.item.EquipItemSlot;
import org.kiye.eternalreturnrootmanagerbackend.domain.item.WeaponType;
import org.kiye.eternalreturnrootmanagerbackend.dto.item.EquipItemDTO;
import org.kiye.eternalreturnrootmanagerbackend.dto.item.ItemSelectResponseDTO;
import org.kiye.eternalreturnrootmanagerbackend.repository.EquipItemRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/erRootManager/items")
@RequiredArgsConstructor
public class ItemSelectController {

    private final EquipItemRepo equipItemRepo;

    @GetMapping("/item-select")
    public ItemSelectResponseDTO getItemSelect(
            @RequestParam String charCode,       // 지금은 안 써도 됨(확장용)
            @RequestParam WeaponType weaponType
    ) {
        Map<EquipItemSlot, List<EquipItemDTO>> map = new EnumMap<>(EquipItemSlot.class);

        // 무기: 무기군 필터 필수
        map.put(EquipItemSlot.WEAPON,
                equipItemRepo
                        .findByEquipItemSlotAndWeaponType(EquipItemSlot.WEAPON, weaponType)
                        .stream().map(EquipItemDTO::from).toList()
        );

        // 나머지 장비: 슬롯별 전체(캐릭터 제한 없으면)
        for (EquipItemSlot slot : List.of(EquipItemSlot.CHEST, EquipItemSlot.HEAD, EquipItemSlot.ARM, EquipItemSlot.LEG)) {
            map.put(slot,
                    equipItemRepo.findByEquipItemSlot(slot)
                            .stream().map(EquipItemDTO::from).toList()
            );
        }

        return new ItemSelectResponseDTO(weaponType, map);
    }
}
