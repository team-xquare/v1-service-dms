package app.xquare.dms.domain.notice.application.port.inbound;

import app.xquare.dms.domain.notice.application.port.inbound.dto.request.CreateNoticeRequest;

public interface CreateNoticeUseCase {

    void createNotice(CreateNoticeRequest request);
}
