package app.xquare.dms.domain.student.application.port.inbound;

import app.xquare.dms.domain.student.application.port.inbound.dto.response.PointListResponse;

public interface GetPointListUseCase {

    PointListResponse getPointList();
}
