package app.xquare.dms.domain.stay.application.port.inbound;

import app.xquare.dms.domain.stay.application.port.inbound.dto.StayApplyListResponse;

public interface GetStayApplyListUseCase {

    StayApplyListResponse getStayApplyList();
}
