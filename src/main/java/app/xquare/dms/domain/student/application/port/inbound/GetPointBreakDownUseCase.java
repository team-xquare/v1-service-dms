package app.xquare.dms.domain.student.application.port.inbound;

import app.xquare.dms.domain.student.domain.PointHistory;

import java.util.List;

public interface GetPointBreakDownUseCase {

    List<PointHistory> getPointBreakDown(Integer grade);
}
