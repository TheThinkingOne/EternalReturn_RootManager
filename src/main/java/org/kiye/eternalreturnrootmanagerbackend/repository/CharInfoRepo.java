package org.kiye.eternalreturnrootmanagerbackend.repository;

import org.kiye.eternalreturnrootmanagerbackend.domain.character.CharInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

// 이부분 Long 으로 빼는게 맞나?
public interface CharInfoRepo extends JpaRepository<CharInfo, Long> {
    Optional<CharInfo> findByCharCode(String charCode);
    // List<CharInfo> findAllBy();
}
