package app.xquare.dms.domain.stay.application.port.inbound.dto;

import app.xquare.dms.domain.stay.domain.StayStatus;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class StayApplyListResponse {

    private final List<StayStatus> students;
}
