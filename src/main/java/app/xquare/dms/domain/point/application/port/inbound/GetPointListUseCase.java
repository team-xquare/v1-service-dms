package app.xquare.dms.domain.point.application.port.inbound;

import app.xquare.dms.domain.point.application.port.inbound.dto.response.PointListResponse;

public interface GetPointListUseCase {

    PointListResponse getPointList();
}
