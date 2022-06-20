package app.xquare.dms.domain.point.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
public class Point {

    private final String id;

    @Setter
    private String reason;

    @Setter
    private Boolean type;

    @Setter
    private Integer point;

    public boolean isGoodPoint() {
        return type;
    }

    public Point negative() {
        point *= -1;
        return this;
    }
}
