package app.xquare.dms.domain.student.adaptor.outbound.persistence.dms;

import app.xquare.dms.domain.student.adaptor.outbound.persistence.dms.entity.PointStatusJpaEntity;
import app.xquare.dms.domain.student.domain.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentPointMapper {

    Student mapToStudent(PointStatusJpaEntity pointStatus) {
        return Student.builder()
                .id(pointStatus.getId())
                .name(pointStatus.getStudent().getName())
                .num(pointStatus.getStudent().getNumber())
                .goodPoint(pointStatus.getGoodPoint())
                .badPoint(pointStatus.getBadPoint())
                .penaltyLevel(pointStatus.getPenaltyLevel())
                .penaltyTrainingStatus(pointStatus.getPenaltyTrainingStatus())
                .build();
    }
}
