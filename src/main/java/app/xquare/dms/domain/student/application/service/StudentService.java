package app.xquare.dms.domain.student.application.service;

import app.xquare.dms.domain.student.application.port.inbound.GetPointHistoryListUseCase;
import app.xquare.dms.domain.student.application.port.inbound.GetStudentListUseCase;
import app.xquare.dms.domain.student.application.port.inbound.GivePointUseCase;
import app.xquare.dms.domain.student.application.port.inbound.dto.PointHistoryListResponse;
import app.xquare.dms.domain.student.application.port.inbound.dto.PointRequest;
import app.xquare.dms.domain.student.application.port.inbound.dto.StudentListResponse;
import app.xquare.dms.domain.student.application.port.outbound.FindPointHistoryPort;
import app.xquare.dms.domain.student.application.port.outbound.FindStudentPort;
import app.xquare.dms.domain.student.domain.PointHistory;
import app.xquare.dms.domain.student.domain.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentService implements GetStudentListUseCase, GetPointHistoryListUseCase, GivePointUseCase {

    private final FindStudentPort findStudentPort;
    private final FindPointHistoryPort findPointHistoryPort;

    @Override
    public StudentListResponse getStudentList() {
        List<Student> students = findStudentPort.findStudent();

        return StudentListResponse.builder()
                .students(students)
                .build();
    }

    @Override
    public PointHistoryListResponse getPointHistoryList(String studentId) {
        List<PointHistory> pointHistories = findPointHistoryPort.findPointHistory(studentId);

        return PointHistoryListResponse.builder()
                .pointHistories(pointHistories)
                .build();
    }

    @Transactional
    @Override
    public void givePoint(String studentId, PointRequest request) {

    }
}
