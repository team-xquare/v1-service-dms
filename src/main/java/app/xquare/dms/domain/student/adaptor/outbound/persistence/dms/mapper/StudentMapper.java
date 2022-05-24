package app.xquare.dms.domain.student.adaptor.outbound.persistence.dms.mapper;

import app.xquare.dms.domain.student.adaptor.outbound.persistence.dms.entity.PointHistoryJpaEntity;
import app.xquare.dms.domain.student.adaptor.outbound.persistence.dms.entity.PointStatusJpaEntity;
import app.xquare.dms.domain.student.adaptor.outbound.persistence.dms.entity.StudentJpaEntity;
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
                .isPenaltyRequired(pointStatus.getPenaltyStatus())
                .build();
    }

    public Student mapToStudent(StudentJpaEntity student) {
        return Student.builder()
                .id(student.getId())
                .name(student.getName())
                .num(student.getNumber())
                .goodPoint(student.getPointStatus().getGoodPoint())
                .badPoint(student.getPointStatus().getBadPoint())
                .penaltyLevel(student.getPointStatus().getPenaltyLevel())
                .isPenaltyRequired(student.getPointStatus().getPenaltyStatus())
                .stayApply(mapStayApplyValue(student.getStayApply().getValue()))
                .mealApply(mapMealApplyValue(student.getMealApply().getValue()))
                .build();
    }

    public PointStatusJpaEntity mapToPointStatusJpaEntity(Student student) {
        return PointStatusJpaEntity.builder()
                .id(student.getId())
                .goodPoint(student.getGoodPoint())
                .badPoint(student.getBadPoint())
                .penaltyLevel(student.getPenaltyLevel())
                .penaltyStatus(student.getIsPenaltyRequired())
                .build();
    }

    public PointHistory mapToPointHistory(PointHistoryJpaEntity pointHistory) {
        return PointHistory.builder()
                .id(pointHistory.getId())
                .name(pointHistory.getStudent().getName())
                .num(pointHistory.getStudent().getNumber())
                .date(pointHistory.getPointDate())
                .reason(pointHistory.getPoint().getReason())
                .point(pointHistory.getPoint().getPoint())
                .pointType(pointHistory.getPoint().getType())
                .build();
    }

    private String mapStayApplyValue(Integer value) {
        switch (value) {
            case 1:
                return "금요귀가";
            case 2:
                return "토요귀가";
            case 3:
                return "토요귀사";
            case 4:
                return "잔류";
            default:
                return null;
        }
    }

    private String mapMealApplyValue(Integer value) {
        switch (value) {
            case 1:
                return "대기";
            case 2:
                return "신청";
            case 3:
                return "미신청";
            default:
                return null;
        }
    }
}
