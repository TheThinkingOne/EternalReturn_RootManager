package org.kiye.eternalreturnrootmanagerbackend.repository;

import org.kiye.eternalreturnrootmanagerbackend.domain.character.CharInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

// 이부분 Long 으로 빼는게 맞나?
public interface CharInfoRepo extends JpaRepository<CharInfo, Long> {
    Optional<CharInfo> findByCharCode(String charCode);
    // List<CharInfo> findAllBy();
    // 캐릭터 출시순 번호(ex: 엠마 19 마커스 53)로 캐릭터 찾기
    Optional<CharInfo> findByCharacterNum(Integer characterNum);
}
