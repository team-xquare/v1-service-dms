package app.xquare.dms.domain.student.application.service;

import app.xquare.dms.domain.student.application.port.inbound.*;
import app.xquare.dms.domain.student.application.port.inbound.dto.response.PointHistoryListResponse;
import app.xquare.dms.domain.student.application.port.inbound.dto.request.PointRequest;
import app.xquare.dms.domain.student.application.port.inbound.dto.response.StudentListResponse;
import app.xquare.dms.domain.student.application.port.outbound.*;
import app.xquare.dms.domain.student.domain.Point;
import app.xquare.dms.domain.student.domain.PointHistory;
import app.xquare.dms.domain.student.domain.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentService implements GetStudentListUseCase, GetPointHistoryListUseCase, GivePointUseCase, DeletePointHistoryUseCase, CompleteTrainingUseCase {

    private final FindStudentPort findStudentPort;
    private final FindPointHistoryPort findPointHistoryPort;
    private final FindPointByIdPort findPointByIdPort;
    private final FindStudentByIdPort findStudentByIdPort;

    private final SavePointHistoryPort savePointHistoryPort;
    private final SaveStudentPort saveStudentPort;

    private final DeletePointHistoryPort deletePointHistoryPort;

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
        // 학생 상점, 벌점 부여 -> 벌점이면 다음 봉사단계가 됐는지 검사 -> 상벌점내역에 추가

        Point point = findPointByIdPort.findPointById(request.getPointId());
        Student student = findStudentByIdPort.findStudentById(studentId);

        student.addPoint(point);

        saveStudentPort.saveStudent(student);
        savePointHistoryPort.savePointHistory(student, point);
    }

    @Override
    public void deletePointHistory(String studentId, String historyId) {
        Student student = findStudentByIdPort.findStudentById(studentId);

        Point point = deletePointHistoryPort.deletePointHistory(historyId);

        student.addPoint(point.negative());

        saveStudentPort.saveStudent(student);
    }

    @Override
    public void completeTraining(String studentId, Integer penaltyLevel) {

    }
}
