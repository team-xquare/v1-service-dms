package app.xquare.dms.domain.point.application.port.inbound;

import app.xquare.dms.domain.point.application.port.inbound.dto.request.PointRuleRequest;

public interface UpdatePointRuleUseCase {
    void updatePointRule(PointRuleRequest request, String pointId);
}
