package app.xquare.dms.domain.student.adaptor.outbound.persistence.dms;

import app.xquare.dms.domain.student.adaptor.outbound.persistence.dms.entity.PointHistoryJpaEntity;
import app.xquare.dms.domain.student.adaptor.outbound.persistence.dms.entity.StudentJpaEntity;
import app.xquare.dms.domain.student.adaptor.outbound.persistence.dms.mapper.PointMapper;
import app.xquare.dms.domain.student.adaptor.outbound.persistence.dms.mapper.StudentMapper;
import app.xquare.dms.domain.student.adaptor.outbound.persistence.dms.repository.PointHistoryRepository;
import app.xquare.dms.domain.student.adaptor.outbound.persistence.dms.repository.PointRepository;
import app.xquare.dms.domain.student.adaptor.outbound.persistence.dms.repository.PointStatusRepository;
import app.xquare.dms.domain.student.adaptor.outbound.persistence.dms.repository.StudentRepository;
import app.xquare.dms.domain.student.application.port.outbound.*;
import app.xquare.dms.domain.student.domain.Point;
import app.xquare.dms.domain.student.domain.PointHistory;
import app.xquare.dms.domain.student.domain.Student;
import app.xquare.dms.domain.student.exception.StudentNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class StudentPersistenceAdaptor implements FindStudentPort, FindPointHistoryPort, FindStudentByIdPort, SavePointHistoryPort, SaveStudentPort {

    private final StudentMapper studentMapper;
    private final PointMapper pointMapper;

    private final StudentRepository studentRepository;
    private final PointRepository pointRepository;
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

    @Override
    public Student findStudentById(String studentId) {
        return studentMapper.mapToStudent(
                pointStatusRepository.findById(studentId)
                        .orElseThrow(() -> StudentNotFoundException.EXCEPTION)
        );
    }

    @Override
    public void savePointHistory(Student student, Point point) {
        StudentJpaEntity studentJpaEntity = studentRepository.findById(student.getId())
                .orElseThrow(() -> StudentNotFoundException.EXCEPTION);

        String id = String.valueOf(pointHistoryRepository.findMaxId() + 1);
        pointHistoryRepository.save(PointHistoryJpaEntity.builder()
                .id(id)
                .pointDate(LocalDate.now())
                .point(pointRepository.save(pointMapper.mapToPointJpaEntity(point)))
                .student(studentJpaEntity)
                .build());
    }

    @Override
    public void saveStudent(Student student) {
        pointStatusRepository.save(studentMapper.mapToPointStatusJpaEntity(student));
    }
}
