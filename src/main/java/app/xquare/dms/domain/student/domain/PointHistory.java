package app.xquare.dms.domain.student.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class PointHistory {

    private final String id;

    private final LocalDate date;

    private final String reason;

    private final Boolean pointType;

    private final Integer point;
}
