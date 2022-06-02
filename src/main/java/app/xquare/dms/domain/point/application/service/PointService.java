package app.xquare.dms.domain.point.application.service;

import app.xquare.dms.domain.point.application.port.inbound.GetPointListUseCase;
import app.xquare.dms.domain.point.application.port.inbound.dto.response.PointListResponse;
import app.xquare.dms.domain.point.application.port.outbound.FindPointPort;
import app.xquare.dms.domain.point.domain.Point;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PointService implements GetPointListUseCase {

    private final FindPointPort findPointPort;

    @Override
    public PointListResponse getPointList() {
        List<Point> points = findPointPort.findPoint();

        return PointListResponse.builder()
                .rules(points)
                .build();
    }
}
