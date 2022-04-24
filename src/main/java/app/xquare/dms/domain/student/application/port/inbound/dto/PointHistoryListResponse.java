package app.xquare.dms.domain.student.application.port.inbound.dto;

import app.xquare.dms.domain.student.domain.PointHistory;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class PointHistoryListResponse {

    private final List<PointHistory> pointHistories;
}
