package org.kiye.eternalreturnrootmanagerbackend.dto.item;

public record RequiredCraftItemsDTO(
        Long craftItemId,
        String craftItemName,
        int requiredCount // 제작 아이템이 몇개 필요한지 표시 해주는거 있으면 좋긴 할듯함
) {
}
