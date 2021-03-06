package app.xquare.dms.domain.point.adaptor.outbound.persistence.dms.mapper;

import app.xquare.dms.domain.point.adaptor.outbound.persistence.dms.entity.PointJpaEntity;
import app.xquare.dms.domain.point.domain.Point;
import org.springframework.stereotype.Component;

@Component
public class PointMapper {

    public Point mapToPoint(PointJpaEntity point) {
        return Point.builder()
                .id(point.getId())
                .reason(point.getReason())
                .type(point.getType())
                .point(point.getPoint())
                .build();
    }

    public PointJpaEntity mapToPointJpaEntity(Point point) {
        return PointJpaEntity.builder()
                .id(point.getId())
                .reason(point.getReason())
                .type(point.getType())
                .point(point.getPoint())
                .build();
    }
}
