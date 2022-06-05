package app.xquare.dms.domain.notice.application.port.inbound;

import app.xquare.dms.domain.notice.application.port.inbound.dto.response.NoticeListResponse;

public interface GetNoticeListUseCase {

    NoticeListResponse getNoticeList();
}
