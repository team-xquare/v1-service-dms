package app.xquare.dms.domain.student.adaptor.outbound.persistence.dms.mapper;

import app.xquare.dms.domain.student.adaptor.outbound.persistence.dms.entity.PointHistoryJpaEntity;
import app.xquare.dms.domain.student.adaptor.outbound.persistence.dms.entity.PointStatusJpaEntity;
import app.xquare.dms.domain.student.domain.PointHistory;
import app.xquare.dms.domain.student.domain.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public Student mapToStudent(PointStatusJpaEntity pointStatus) {
        return Student.builder()
                .id(pointStatus.getId())
                .name(pointStatus.getStudent().getName())
                .num(pointStatus.getStudent().getNumber())
                .goodPoint(pointStatus.getGoodPoint())
                .badPoint(pointStatus.getBadPoint())
                .penaltyLevel(pointStatus.getPenaltyLevel())
                .isPenaltyDone(pointStatus.getPenaltyStatus())
                .build();
    }

    public PointHistory mapToPointHistory(PointHistoryJpaEntity pointHistory) {
        return PointHistory.builder()
                .id(pointHistory.getId())
                .date(pointHistory.getPointDate())
                .reason(pointHistory.getPoint().getReason())
                .point(pointHistory.getPoint().getPoint())
                .pointType(pointHistory.getPoint().getType())
                .build();
    }
}
