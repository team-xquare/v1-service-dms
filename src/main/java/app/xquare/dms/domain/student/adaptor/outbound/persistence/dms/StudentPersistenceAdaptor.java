package app.xquare.dms.domain.student.adaptor.outbound.persistence.dms;

import app.xquare.dms.domain.student.adaptor.outbound.persistence.dms.entity.StudentJpaEntity;
import app.xquare.dms.domain.student.adaptor.outbound.persistence.dms.mapper.StudentMapper;
import app.xquare.dms.domain.student.adaptor.outbound.persistence.dms.repository.PointHistoryRepository;
import app.xquare.dms.domain.student.adaptor.outbound.persistence.dms.repository.PointStatusRepository;
import app.xquare.dms.domain.student.adaptor.outbound.persistence.dms.repository.StudentRepository;
import app.xquare.dms.domain.student.application.port.inbound.dto.PointHistoryListResponse;
import app.xquare.dms.domain.student.application.port.outbound.FindPointHistoryPort;
import app.xquare.dms.domain.student.application.port.outbound.FindStudentPort;
import app.xquare.dms.domain.student.domain.PointHistory;
import app.xquare.dms.domain.student.domain.Student;
import app.xquare.dms.domain.student.exception.StudentNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class StudentPersistenceAdaptor implements FindStudentPort, FindPointHistoryPort {

    private final StudentMapper studentMapper;

    private final StudentRepository studentRepository;
    private final PointStatusRepository pointStatusRepository;
    private final PointHistoryRepository pointHistoryRepository;

    @Override
    public List<Student> findStudent() {
        return pointStatusRepository.findAllOrderByStudentNumber().stream()
                .map(studentMapper::mapToStudent)
                .collect(Collectors.toList());
    }

    @Override
    public List<PointHistory> findPointHistory(String studentId) {
        StudentJpaEntity student = studentRepository.findById(studentId)
                .orElseThrow(() -> StudentNotFoundException.EXCEPTION);

        return pointHistoryRepository.findByStudent(student).stream()
                .map(studentMapper::mapToPointHistory)
                .collect(Collectors.toList());
    }
}
