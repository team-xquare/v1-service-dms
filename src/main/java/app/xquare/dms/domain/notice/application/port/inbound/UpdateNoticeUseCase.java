package app.xquare.dms.domain.notice.application.port.inbound;

import app.xquare.dms.domain.notice.application.port.inbound.dto.request.UpdateNoticeRequest;

public interface UpdateNoticeUseCase {

    void updateNotice(UpdateNoticeRequest request, String id);
}
