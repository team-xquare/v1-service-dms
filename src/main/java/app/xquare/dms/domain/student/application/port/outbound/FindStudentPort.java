package app.xquare.dms.domain.student.application.port.outbound;

import app.xquare.dms.domain.student.domain.Student;

import java.util.List;

public interface FindStudentPort {

    List<Student> findStudent();
}
