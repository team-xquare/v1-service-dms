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
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StudentService implements GetStudentListUseCase, GetPointHistoryListUseCase, GivePointUseCase, DeletePointHistoryUseCase, CompleteTrainingUseCase, GetPointBreakDownUseCase {

    private final FindStudentPort findStudentPort;
    private final FindPointHistoryByStudentPort findPointHistoryByStudentPort;
    private final FindPointByIdPort findPointByIdPort;
    private final FindStudentByIdPort findStudentByIdPort;
    private final FindCompleteTrainingPointPort findCompleteTrainingPointPort;

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
        List<PointHistory> pointHistories = findPointHistoryByStudentPort.findPointHistoryByStudent(studentId);

        return PointHistoryListResponse.builder()
                .pointHistories(pointHistories.stream().map(p -> PointHistoryListResponse.PointHistory.builder()
                        .id(p.getId())
                        .date(p.getDate())
                        .reason(p.getReason())
                        .pointType(p.getPointType())
                        .point(p.getPoint())
                        .build())
                        .collect(Collectors.toList()))
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
        savePointHistoryPort.savePointHistory(student, List.of(point));
    }

    @Transactional
    @Override
    public void deletePointHistory(String studentId, String historyId) {
        Student student = findStudentByIdPort.findStudentById(studentId);

        Point point = deletePointHistoryPort.deletePointHistory(historyId);

        student.addPoint(point.negative());

        saveStudentPort.saveStudent(student);
    }

    @Transactional
    @Override
    public void completeTraining(String studentId, Integer penaltyLevel) {
        Student student = findStudentByIdPort.findStudentById(studentId);

        List<Point> points = findCompleteTrainingPointPort.findCompleteTrainingPoint(penaltyLevel);

        for (Point point : points) {
            student.addPoint(point);
        }

        savePointHistoryPort.savePointHistory(student, points);

        saveStudentPort.saveStudent(student);
    }

    @Override
    public List<PointHistory> getPointBreakDown(Integer grade) {
        return null;
    }
}
