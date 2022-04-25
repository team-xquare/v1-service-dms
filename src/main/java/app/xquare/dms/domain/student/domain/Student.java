package app.xquare.dms.domain.student.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Student {

    private final String id;

    private final String name;

    private final String num;

    private final Integer goodPoint;

    private final Integer badPoint;

    private final Integer penaltyLevel;

    private final Boolean isPenaltyRequired;
}
