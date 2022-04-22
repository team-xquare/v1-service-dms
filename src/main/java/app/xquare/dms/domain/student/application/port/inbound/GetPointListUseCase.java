package app.xquare.dms.domain.student.application.port.inbound;

import app.xquare.dms.domain.student.application.port.inbound.dto.PointListResponse;

public interface GetPointListUseCase {
    PointListResponse getPointList();
}
