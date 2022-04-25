package app.xquare.dms.domain.student.application.port.outbound;

import app.xquare.dms.domain.student.domain.Point;
import app.xquare.dms.domain.student.domain.Student;

public interface SavePointHistoryPort {

    void savePointHistory(Student student, Point point);
}
