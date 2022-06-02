package app.xquare.dms.domain.point.application.service;

import app.xquare.dms.domain.point.application.port.inbound.CreatePointRuleUseCase;
import app.xquare.dms.domain.point.application.port.inbound.GetPointListUseCase;
import app.xquare.dms.domain.point.application.port.inbound.dto.request.PointRuleRequest;
import app.xquare.dms.domain.point.application.port.inbound.dto.response.PointListResponse;
import app.xquare.dms.domain.point.application.port.outbound.FindPointPort;
import app.xquare.dms.domain.point.application.port.outbound.SavePointPort;
import app.xquare.dms.domain.point.domain.Point;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PointService implements GetPointListUseCase, CreatePointRuleUseCase {

    private final FindPointPort findPointPort;
    private final SavePointPort savePointPort;

    @Override
    public PointListResponse getPointList() {
        List<Point> points = findPointPort.findPoint();

        return PointListResponse.builder()
                .rules(points)
                .build();
    }

    @Transactional
    @Override
    public void createPointRule(PointRuleRequest request) {
        Point point = Point.builder()
                .point(request.getPoint())
                .reason(request.getReason())
                .type(request.getType())
                .build();

        savePointPort.savePoint(point);
    }
}
