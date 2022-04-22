package app.xquare.dms.domain.student.adaptor.outbound.persistence.dms;

import app.xquare.dms.domain.student.adaptor.outbound.persistence.dms.mapper.StudentMapper;
import app.xquare.dms.domain.student.adaptor.outbound.persistence.dms.repository.PointStatusRepository;
import app.xquare.dms.domain.student.application.port.outbound.FindStudentPort;
import app.xquare.dms.domain.student.domain.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class StudentPersistenceAdaptor implements FindStudentPort {

    private final StudentMapper studentMapper;

    private final PointStatusRepository pointStatusRepository;

    @Override
    public List<Student> findStudent() {
        return pointStatusRepository.findAllOrderByStudentNumber().stream()
                .map(studentMapper::mapToStudent)
                .collect(Collectors.toList());
    }
}
