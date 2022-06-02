package app.xquare.dms.domain.point.application.port.inbound;

import app.xquare.dms.domain.point.application.port.inbound.dto.request.PointRuleRequest;

public interface CreatePointRuleUseCase {

    void createPointRule(PointRuleRequest request);
}
