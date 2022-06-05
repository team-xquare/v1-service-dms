package app.xquare.dms.domain.notice.adaptor.inbound.web;

import app.xquare.dms.domain.notice.application.port.inbound.CreateNoticeUseCase;
import app.xquare.dms.domain.notice.application.port.inbound.DeleteNoticeUseCase;
import app.xquare.dms.domain.notice.application.port.inbound.GetNoticeListUseCase;
import app.xquare.dms.domain.notice.application.port.inbound.UpdateNoticeUseCase;
import app.xquare.dms.domain.notice.application.port.inbound.dto.request.CreateNoticeRequest;
import app.xquare.dms.domain.notice.application.port.inbound.dto.request.UpdateNoticeRequest;
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
    private final UpdateNoticeUseCase updateNoticeUseCase;
    private final DeleteNoticeUseCase deleteNoticeUseCase;

    @GetMapping
    public NoticeListResponse noticeList() {
        return getNoticeListUseCase.getNoticeList();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void notice(@Valid @RequestBody CreateNoticeRequest request) {
        createNoticeUseCase.createNotice(request);
    }

    @PutMapping("/{notice-id}")
    public void notice(@Valid @RequestBody UpdateNoticeRequest request, @PathVariable("notice-id") String noticeId) {
        updateNoticeUseCase.updateNotice(request, noticeId);
    }

    @DeleteMapping("/{notice-id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void notice(@PathVariable("notice-id") String noticeId) {
        deleteNoticeUseCase.deleteNotice(noticeId);
    }
}
