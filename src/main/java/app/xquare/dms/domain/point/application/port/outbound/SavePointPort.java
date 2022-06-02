package app.xquare.dms.domain.point.application.port.outbound;

import app.xquare.dms.domain.point.domain.Point;

public interface SavePointPort {

    void savePoint(Point point);
}
