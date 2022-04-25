package app.xquare.dms.domain.student.application.port.outbound;

import app.xquare.dms.domain.student.domain.Student;

public interface SaveStudentPort {

    void saveStudent(Student student);
}
