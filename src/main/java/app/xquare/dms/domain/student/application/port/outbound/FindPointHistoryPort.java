package app.xquare.dms.domain.student.application.port.outbound;

import app.xquare.dms.domain.student.domain.PointHistory;

import java.util.List;

public interface FindPointHistoryPort {

    List<PointHistory> findPointHistory(String studentId);
}
