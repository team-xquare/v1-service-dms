package app.xquare.dms.domain.student.application.port.inbound.dto.response;

import app.xquare.dms.domain.student.domain.Point;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class PointListResponse {

    private final List<Point> rules;
}
