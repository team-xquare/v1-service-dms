package app.xquare.dms.domain.student.application.service;

import app.xquare.dms.domain.student.application.port.inbound.GetStudentListUseCase;
import app.xquare.dms.domain.student.application.port.inbound.dto.StudentListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StudentService implements GetStudentListUseCase {

    @Override
    public StudentListResponse getStudentList() {
        return null;
    }
}
