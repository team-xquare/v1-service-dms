package app.xquare.dms.domain.notice.application.port.outbound;

import app.xquare.dms.domain.notice.domain.Notice;

public interface SaveNoticePort {

    void saveNotice(Notice notice);
}
