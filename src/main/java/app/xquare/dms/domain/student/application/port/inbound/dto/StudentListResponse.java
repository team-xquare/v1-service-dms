package app.xquare.dms.domain.student.application.port.inbound.dto;

import app.xquare.dms.domain.student.domain.Student;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class StudentListResponse {

    private final List<Student> students;
}
