package org.kiye.eternalreturnrootmanagerbackend.controller;

import lombok.RequiredArgsConstructor;
import org.kiye.eternalreturnrootmanagerbackend.domain.item.EquipItemRecipe;
import org.kiye.eternalreturnrootmanagerbackend.domain.item.EquipItemSlot;
import org.kiye.eternalreturnrootmanagerbackend.domain.item.WeaponType;
import org.kiye.eternalreturnrootmanagerbackend.repository.EquipItemRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/erRootManager/items")
@RequiredArgsConstructor
public class ItemSelectController {

    private final EquipItemRepo equipItemRepo;

    // 해당 캐릭터 무기군에 맞는 보라템 무기 목록
    @GetMapping("/weapons") // 한 getMapping 안에 캐릭터 무기군별 무기목록과 나머지 4개 장비들 목록 띄우는걸로 해야함
    public List<EquipItemDTO> getWeaponItems(@RequestParam WeaponType weaponType) {
        return equipItemRepo.findBySlotAndWeaponType(
                EquipItemSlot.WEAPON,
                weaponType
        ).stream()
                .map(EquipItemDTO::from)
                .toList();
    }

    // 슬롯별(상의, 머리, 팔, 다리) 장비 목록
    @GetMapping("/equips")
    public List<EquipItemDto> getEquipItems(@RequestParam EquipItemSlot slot) {
        return equipItemsRepository.findByEquipItemSlot(slot).stream()
                .map(EquipItemDto::from)
                .toList();
    }




}
