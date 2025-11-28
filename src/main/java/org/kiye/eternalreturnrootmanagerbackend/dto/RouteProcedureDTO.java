package org.kiye.eternalreturnrootmanagerbackend.dto;

public record RouteProcedureDTO(
        int order,
        Long RegionId,
        String regionName,
        boolean viaHyperloop // 이전 지역에서 하이퍼루트를 탔는지?
        // 근데 이전지역에서 하이퍼루트 탔는지 여부를 아라야 하나?
        // 차라리 해당 지역에 하이퍼루프가 있는지 여부를 알아야 하는거 아님?
) {
}
