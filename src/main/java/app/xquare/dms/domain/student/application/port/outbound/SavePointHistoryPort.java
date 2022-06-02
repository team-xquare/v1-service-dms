package app.xquare.dms.domain.student.application.port.outbound;

import app.xquare.dms.domain.point.domain.Point;
import app.xquare.dms.domain.student.domain.Student;

import java.util.List;

public interface SavePointHistoryPort {

    void savePointHistory(Student student, List<Point> points);
}
