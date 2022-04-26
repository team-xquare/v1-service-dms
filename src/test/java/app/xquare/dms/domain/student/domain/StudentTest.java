package app.xquare.dms.domain.student.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StudentTest {

    private Student student;

    @BeforeEach
    void setUp() {
        student = Student.builder()
                .goodPoint(0)
                .badPoint(0)
                .penaltyLevel(0)
                .isPenaltyRequired(false)
                .build();
    }

    @Test
    void 상점부여() {
        int pointValue = 3;
        Point point = goodPoint(pointValue);

        student.addPoint(point);

        assertThat(student.getGoodPoint()).isEqualTo(pointValue);
        assertThat(student.getIsPenaltyRequired()).isFalse();
    }

    @Test
    void 벌점부여() {
        int pointValue = 3;
        Point point = badPoint(pointValue);

        student.addPoint(point);

        assertThat(student.getBadPoint()).isEqualTo(pointValue);
        assertThat(student.getIsPenaltyRequired()).isFalse();
    }

    @Test
    void 벌점부여_1차봉사() {
        int pointValue = PenaltyLevel.BOUNDS[1];
        Point point = badPoint(pointValue);

        student.addPoint(point);

        assertThat(student.getPenaltyLevel()).isEqualTo(1);
        assertThat(student.getIsPenaltyRequired()).isTrue();
    }

    @Test
    void 벌점부여_봉사완료() {
        int pointValue = PenaltyLevel.BOUNDS[1];
        student.addPoint(badPoint(pointValue));
        student.addPoint(goodPoint(pointValue));

        student.completeTraining();

        assertThat(student.getBadPoint()).isEqualTo(pointValue - 5);
        assertThat(student.getIsPenaltyRequired()).isFalse();
    }

    @Test
    void 벌점부여_1차봉사_뒤에2차() {
        int point1 = PenaltyLevel.BOUNDS[1];
        int point2 = PenaltyLevel.BOUNDS[2] - PenaltyLevel.BOUNDS[1];

        student.addPoint(badPoint(point1));
        student.addPoint(badPoint(point2));

        assertThat(student.getPenaltyLevel()).isEqualTo(1);
    }


    @Test
    void 연속봉사() {
        int point1 = PenaltyLevel.BOUNDS[1];
        int point2 = PenaltyLevel.BOUNDS[2] - PenaltyLevel.BOUNDS[1] + 5;

        student.addPoint(goodPoint(point1));
        student.addPoint(badPoint(point1));
        student.addPoint(badPoint(point2));

        student.completeTraining();

        assertThat(student.getPenaltyLevel()).isEqualTo(2);
    }

    private Point goodPoint(Integer pointValue) {
        return Point.builder()
                .type(true)
                .point(pointValue)
                .build();
    }

    private Point badPoint(Integer pointValue) {
        return Point.builder()
                .type(false)
                .point(pointValue)
                .build();
    }
}
