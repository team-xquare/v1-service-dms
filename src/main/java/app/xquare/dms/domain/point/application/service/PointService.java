package app.xquare.dms.domain.point.application.service;

import app.xquare.dms.domain.point.application.port.inbound.CreatePointRuleUseCase;
import app.xquare.dms.domain.point.application.port.inbound.DeletePointRuleUseCase;
import app.xquare.dms.domain.point.application.port.inbound.GetPointListUseCase;
import app.xquare.dms.domain.point.application.port.inbound.UpdatePointRuleUseCase;
import app.xquare.dms.domain.point.application.port.inbound.dto.request.PointRuleRequest;
import app.xquare.dms.domain.point.application.port.inbound.dto.response.PointListResponse;
import app.xquare.dms.domain.point.application.port.outbound.DeletePointPort;
import app.xquare.dms.domain.point.application.port.outbound.FindPointPort;
import app.xquare.dms.domain.point.application.port.outbound.SavePointPort;
import app.xquare.dms.domain.point.domain.Point;
import app.xquare.dms.domain.point.application.port.outbound.FindPointByIdPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PointService implements GetPointListUseCase, CreatePointRuleUseCase, DeletePointRuleUseCase, UpdatePointRuleUseCase {

    private final FindPointPort findPointPort;
    private final FindPointByIdPort findPointByIdPort;
    private final DeletePointPort deletePointPort;
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

    @Transactional
    @Override
    public void deletePointRule(String pointId) {
        deletePointPort.deletePoint(pointId);
    }

    @Transactional
    @Override
    public void updatePointRule(PointRuleRequest request, String pointId) {
        Point point = findPointByIdPort.findPointById(pointId);

        point.setPoint(request.getPoint());
        point.setReason(request.getReason());
        point.setType(request.getType());

        savePointPort.savePoint(point);
    }
}
