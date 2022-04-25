package app.xquare.dms.domain.student.adaptor.outbound.persistence.dms;

import app.xquare.dms.domain.student.adaptor.outbound.persistence.dms.mapper.PointMapper;
import app.xquare.dms.domain.student.adaptor.outbound.persistence.dms.repository.PointRepository;
import app.xquare.dms.domain.student.application.port.outbound.FindCompleteTrainingPointPort;
import app.xquare.dms.domain.student.application.port.outbound.FindPointByIdPort;
import app.xquare.dms.domain.student.application.port.outbound.FindPointPort;
import app.xquare.dms.domain.student.domain.Point;
import app.xquare.dms.domain.student.exception.PointNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class PointPersistenceAdaptor implements FindPointPort, FindPointByIdPort, FindCompleteTrainingPointPort {

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
        return null;
    }
}
