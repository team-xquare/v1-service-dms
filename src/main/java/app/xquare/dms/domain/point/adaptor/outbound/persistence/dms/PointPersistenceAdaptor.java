package app.xquare.dms.domain.point.adaptor.outbound.persistence.dms;

import app.xquare.dms.domain.point.adaptor.outbound.persistence.dms.entity.PointJpaEntity;
import app.xquare.dms.domain.point.adaptor.outbound.persistence.dms.mapper.PointMapper;
import app.xquare.dms.domain.point.adaptor.outbound.persistence.dms.repository.PointRepository;
import app.xquare.dms.domain.point.application.port.outbound.*;
import app.xquare.dms.domain.point.domain.Point;
import app.xquare.dms.domain.point.exception.PointNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class PointPersistenceAdaptor implements FindPointPort, FindPointByIdPort, FindCompleteTrainingPointPort, SavePointPort, DeletePointPort {

    private final PointMapper pointMapper;

    private final PointRepository pointRepository;

    @Override
    public List<Point> findPoint() {
        return pointRepository.findAll().stream()
                .map(pointMapper::mapToPoint)
                .collect(Collectors.toList());
    }

    @Override
    public Point findPointById(String pointId) {
        return pointMapper.mapToPoint(
                pointRepository.findById(pointId)
                        .orElseThrow(() -> PointNotFoundException.EXCEPTION)
        );
    }

    @Override
    public List<Point> findCompleteTrainingPoint(Integer penaltyLevel) {
        PointJpaEntity point1, point2;
        switch (penaltyLevel) {
            case 1: // 313, 341
                point1 = pointRepository.findById("313")
                        .orElseThrow(() -> PointNotFoundException.EXCEPTION);
                point2 = pointRepository.findById("341")
                        .orElseThrow(() -> PointNotFoundException.EXCEPTION);
                return List.of(pointMapper.mapToPoint(point1), pointMapper.mapToPoint(point2));
            case 2: // 314, 342
                point1 = pointRepository.findById("314")
                        .orElseThrow(() -> PointNotFoundException.EXCEPTION);
                point2 = pointRepository.findById("342")
                        .orElseThrow(() -> PointNotFoundException.EXCEPTION);
                return List.of(pointMapper.mapToPoint(point1), pointMapper.mapToPoint(point2));
            case 3: // 315, 343
                point1 = pointRepository.findById("315")
                        .orElseThrow(() -> PointNotFoundException.EXCEPTION);
                point2 = pointRepository.findById("343")
                        .orElseThrow(() -> PointNotFoundException.EXCEPTION);
                return List.of(pointMapper.mapToPoint(point1), pointMapper.mapToPoint(point2));
            default:
                return Collections.emptyList();
        }
    }

    @Override
    public void savePoint(Point point) {
        pointRepository.save(pointMapper.mapToPointJpaEntity(point));
    }

    @Override
    public void deletePoint(String pointId) {
        PointJpaEntity point = pointRepository.findById(pointId)
                .orElseThrow(() -> PointNotFoundException.EXCEPTION);

        pointRepository.delete(point);
    }
}
