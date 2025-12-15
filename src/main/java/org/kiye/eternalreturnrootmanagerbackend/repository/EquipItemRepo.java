package org.kiye.eternalreturnrootmanagerbackend.repository;

import org.kiye.eternalreturnrootmanagerbackend.domain.item.EquipItemSlot;
import org.kiye.eternalreturnrootmanagerbackend.domain.item.EquipItems;
import org.kiye.eternalreturnrootmanagerbackend.domain.item.WeaponType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipItemRepo extends JpaRepository<EquipItems, Long> {
    List<EquipItems> findByEquipItemSlot(EquipItemSlot equipItemSlot);
    List<EquipItems> findBySlotAndWeaponType(EquipItemSlot equipItemSlot, WeaponType weaponType);
}
