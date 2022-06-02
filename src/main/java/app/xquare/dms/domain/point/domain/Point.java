package app.xquare.dms.domain.point.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Point {

    private final String id;

    private final String reason;

    private final Boolean type;

    private Integer point;

    public boolean isGoodPoint() {
        return type;
    }

    public Point negative() {
        point *= -1;
        return this;
    }
}
