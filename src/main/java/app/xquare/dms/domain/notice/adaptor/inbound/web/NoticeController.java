package app.xquare.dms.domain.notice.adaptor.inbound.web;

import app.xquare.dms.domain.notice.application.port.inbound.GetNoticeListUseCase;
import app.xquare.dms.domain.notice.application.port.inbound.dto.response.NoticeListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/notices")
public class NoticeController {

    private final GetNoticeListUseCase getNoticeListUseCase;

    @GetMapping
    public NoticeListResponse noticeList() {
        return getNoticeListUseCase.getNoticeList();
    }
}
