package app.xquare.dms.domain.student.adaptor.outbound.persistence.dms;

import app.xquare.dms.domain.student.adaptor.outbound.persistence.dms.mapper.PointMapper;
import app.xquare.dms.domain.student.adaptor.outbound.persistence.dms.repository.PointRepository;
import app.xquare.dms.domain.student.application.port.outbound.FindPointPort;
import app.xquare.dms.domain.student.domain.Point;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class PointPersistenceAdaptor implements FindPointPort {

    private final PointMapper pointMapper;

    private final PointRepository pointRepository;

    @Override
    public List<Point> findPoint() {
        return pointRepository.findAll().stream()
                .map(pointMapper::mapToPoint)
                .collect(Collectors.toList());
    }
}
