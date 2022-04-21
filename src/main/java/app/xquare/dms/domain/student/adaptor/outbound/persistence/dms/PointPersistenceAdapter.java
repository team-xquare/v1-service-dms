package app.xquare.dms.domain.student.adaptor.outbound.persistence.dms;

import app.xquare.dms.domain.student.application.port.outbound.FindStudentPort;
import app.xquare.dms.domain.student.domain.Student;

import java.util.List;

public class PointPersistenceAdapter implements FindStudentPort {

    @Override
    public List<Student> findStudent() {
        return null;
    }
}
