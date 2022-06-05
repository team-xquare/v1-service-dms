package app.xquare.dms.domain.notice.application.port.outbound;

import app.xquare.dms.domain.notice.domain.Notice;

public interface FindNoticeByIdPort {

    Notice findNoticeById(String id);
}
