package app.xquare.dms.domain.student.adaptor.outbound.persistence.dms;

import app.xquare.dms.domain.student.adaptor.outbound.persistence.dms.repository.PointStatusRepository;
import app.xquare.dms.domain.student.application.port.outbound.FindStudentPort;
import app.xquare.dms.domain.student.domain.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class StudentPointPersistenceAdapter implements FindStudentPort {

    private final StudentPointMapper studentPointMapper;

    private final PointStatusRepository pointStatusRepository;

    @Override
    public List<Student> findStudent() {
        return pointStatusRepository.findAll().stream()
                .map(studentPointMapper::mapToStudent)
                .collect(Collectors.toList());
    }
}
