package app.xquare.dms.domain.student.application.port.outbound;

import app.xquare.dms.domain.student.domain.Point;

import java.util.List;

public interface FindCompleteTrainingPointPort {

    List<Point> findCompleteTrainingPoint(Integer penaltyLevel);
}