package app.xquare.dms.domain.student.application.port.inbound;

import app.xquare.dms.domain.student.application.port.inbound.dto.PointHistoryListResponse;

public interface GetPointHistoryListUseCase {

    PointHistoryListResponse getPointHistoryList(String studentId);
}
