package app.xquare.dms.domain.notice.application.service;

import app.xquare.dms.domain.notice.application.port.inbound.GetNoticeListUseCase;
import app.xquare.dms.domain.notice.application.port.inbound.dto.response.NoticeListResponse;
import app.xquare.dms.domain.notice.application.port.outbound.FindNoticePort;
import app.xquare.dms.domain.notice.domain.Notice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class NoticeService implements GetNoticeListUseCase {

    private final FindNoticePort findNoticePort;

    @Override
    public NoticeListResponse getNoticeList() {
        List<Notice> notices = findNoticePort.findNotice();

        return NoticeListResponse.builder()
                .notices(notices)
                .build();
    }
}
