package app.xquare.dms.domain.stay.application.service;

import app.xquare.dms.domain.stay.application.port.inbound.GetStayApplyListUseCase;
import app.xquare.dms.domain.stay.application.port.inbound.dto.StayApplyListResponse;
import app.xquare.dms.domain.stay.application.port.outbound.GetStayStatusListPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StayService implements GetStayApplyListUseCase {

    private final GetStayStatusListPort getStayStatusListPort;

    @Override
    public StayApplyListResponse getStayApplyList() {
        return StayApplyListResponse.builder()
                .students(getStayStatusListPort.getStayStatusList())
                .build();
    }
}
