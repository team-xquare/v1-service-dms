package app.xquare.dms.domain.student.application.port.inbound.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Builder
@Getter
public class PointHistoryListResponse {

    private final List<PointHistory> pointHistories;

    @Builder
    @Getter
    public static class PointHistory {

        private final String id;

        private final LocalDate date;

        private final String reason;

        private final Boolean pointType;

        private final Integer point;
    }
}
