package app.xquare.dms.domain.notice.application.service;

import app.xquare.dms.domain.notice.application.port.inbound.CreateNoticeUseCase;
import app.xquare.dms.domain.notice.application.port.inbound.DeleteNoticeUseCase;
import app.xquare.dms.domain.notice.application.port.inbound.GetNoticeListUseCase;
import app.xquare.dms.domain.notice.application.port.inbound.UpdateNoticeUseCase;
import app.xquare.dms.domain.notice.application.port.inbound.dto.request.CreateNoticeRequest;
import app.xquare.dms.domain.notice.application.port.inbound.dto.request.UpdateNoticeRequest;
import app.xquare.dms.domain.notice.application.port.inbound.dto.response.NoticeListResponse;
import app.xquare.dms.domain.notice.application.port.outbound.*;
import app.xquare.dms.domain.notice.domain.Notice;
import app.xquare.dms.domain.notice.exception.NoticeNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class NoticeService implements GetNoticeListUseCase, CreateNoticeUseCase, UpdateNoticeUseCase, DeleteNoticeUseCase {

    private final FindNoticePort findNoticePort;
    private final SaveNoticePort saveNoticePort;
    private final FindNoticeByIdPort findNoticeByIdPort;
    private final DeleteNoticeByIdPort deleteNoticeByIdPort;
    private final ExistsByIdPort existsByIdPort;

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

    @Transactional
    @Override
    public void updateNotice(UpdateNoticeRequest request, String id) {
        Notice notice = findNoticeByIdPort.findNoticeById(id);

        notice.setTitle(request.getTitle());
        notice.setContent(request.getContent());

        saveNoticePort.saveNotice(notice);
    }

    @Override
    public void deleteNotice(String id) {
        if(!existsByIdPort.existsById(id)) {
            throw NoticeNotFoundException.EXCEPTION;
        }

        deleteNoticeByIdPort.deleteNoticeById(id);
    }
}
