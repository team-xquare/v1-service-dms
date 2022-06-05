package app.xquare.dms.domain.notice.adaptor.inbound.web;

import app.xquare.dms.domain.notice.application.port.inbound.CreateNoticeUseCase;
import app.xquare.dms.domain.notice.application.port.inbound.GetNoticeListUseCase;
import app.xquare.dms.domain.notice.application.port.inbound.dto.request.CreateNoticeRequest;
import app.xquare.dms.domain.notice.application.port.inbound.dto.response.NoticeListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/notices")
public class NoticeController {

    private final GetNoticeListUseCase getNoticeListUseCase;
    private final CreateNoticeUseCase createNoticeUseCase;

    @GetMapping
    public NoticeListResponse noticeList() {
        return getNoticeListUseCase.getNoticeList();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void notice(@Valid @RequestBody CreateNoticeRequest request) {
        createNoticeUseCase.createNotice(request);
    }
}
