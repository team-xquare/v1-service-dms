package app.xquare.dms.domain.student.application.port.inbound;

import app.xquare.dms.domain.student.application.port.inbound.dto.request.PointRequest;

public interface GivePointUseCase {

    void givePoint(String studentId, PointRequest request);
}
