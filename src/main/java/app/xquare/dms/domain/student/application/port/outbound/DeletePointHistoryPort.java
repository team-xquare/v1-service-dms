package app.xquare.dms.domain.student.application.port.outbound;

import app.xquare.dms.domain.point.domain.Point;

public interface DeletePointHistoryPort {

    Point deletePointHistory(String historyId);
}
