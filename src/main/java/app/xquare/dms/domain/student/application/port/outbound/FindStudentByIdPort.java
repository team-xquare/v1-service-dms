package app.xquare.dms.domain.student.application.port.outbound;

import app.xquare.dms.domain.student.domain.Student;

public interface FindStudentByIdPort {

    Student findStudentById(String studentId);
}
