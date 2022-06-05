package app.xquare.dms.domain.notice.application.service;

import app.xquare.dms.domain.notice.application.port.inbound.CreateNoticeUseCase;
import app.xquare.dms.domain.notice.application.port.inbound.GetNoticeListUseCase;
import app.xquare.dms.domain.notice.application.port.inbound.dto.request.CreateNoticeRequest;
import app.xquare.dms.domain.notice.application.port.inbound.dto.response.NoticeListResponse;
import app.xquare.dms.domain.notice.application.port.outbound.FindNoticePort;
import app.xquare.dms.domain.notice.application.port.outbound.SaveNoticePort;
import app.xquare.dms.domain.notice.domain.Notice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class NoticeService implements GetNoticeListUseCase, CreateNoticeUseCase {

    private final FindNoticePort findNoticePort;
    private final SaveNoticePort saveNoticePort;

    @Override
    public NoticeListResponse getNoticeList() {
        List<Notice> notices = findNoticePort.findNotice();

        return NoticeListResponse.builder()
                .notices(notices)
                .build();
    }

    @Override
    public void createNotice(CreateNoticeRequest request) {
        Notice notice = Notice.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .createdAt(LocalDateTime.now())
                .build();

        saveNoticePort.saveNotice(notice);
    }
}
