package app.xquare.dms.domain.stay.adaptor.outbound.persistence.dms.mapper;

import app.xquare.dms.domain.stay.adaptor.outbound.persistence.dms.entity.StayStatusJpaEntity;
import app.xquare.dms.domain.stay.domain.StayStatus;
import org.springframework.stereotype.Component;

@Component
public class StayStatusMapper {

    public StayStatus mapToStayStatus(StayStatusJpaEntity stayStatus) {
        return StayStatus.builder()
                .id(stayStatus.getId())
                .name(stayStatus.getStudent().getName())
                .num(stayStatus.getStudent().getNumber())
                .stay(StayStatus.getStayValue(stayStatus.getValue()))
                .build();
    }
}
