package app.xquare.dms.domain.notice.application.port.outbound;

 import app.xquare.dms.domain.notice.domain.Notice;

import java.util.List;

public interface FindNoticePort {

    List<Notice> findNotice();
}
