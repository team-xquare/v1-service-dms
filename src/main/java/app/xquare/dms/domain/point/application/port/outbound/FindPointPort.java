package app.xquare.dms.domain.point.application.port.outbound;

import app.xquare.dms.domain.point.domain.Point;

import java.util.List;

public interface FindPointPort {

    List<Point> findPoint();
}
