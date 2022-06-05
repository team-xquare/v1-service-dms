package app.xquare.dms.domain.notice.application.port.inbound.dto.response;

import app.xquare.dms.domain.notice.domain.Notice;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class NoticeListResponse {

    private final List<Notice> notices;
}
