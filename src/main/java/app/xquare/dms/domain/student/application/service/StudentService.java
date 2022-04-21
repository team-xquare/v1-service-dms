package app.xquare.dms.domain.student.application.service;

import app.xquare.dms.domain.student.application.port.inbound.GetStudentListUseCase;
import app.xquare.dms.domain.student.application.port.inbound.dto.StudentListResponse;
import app.xquare.dms.domain.student.application.port.outbound.FindStudentPort;
import app.xquare.dms.domain.student.domain.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentService implements GetStudentListUseCase {

    private final FindStudentPort findStudentPort;

    @Override
    public StudentListResponse getStudentList() {
        List<Student> students = findStudentPort.findStudent();

        return StudentListResponse.builder()
                .students(students)
                .build();
    }
}
