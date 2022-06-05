package app.xquare.dms.domain.notice.adaptor.outbound.persistence.dms;

import app.xquare.dms.domain.notice.adaptor.outbound.persistence.dms.entity.NoticeJpaEntity;
import app.xquare.dms.domain.notice.adaptor.outbound.persistence.dms.mapper.NoticeMapper;
import app.xquare.dms.domain.notice.adaptor.outbound.persistence.dms.repository.NoticeRepository;
import app.xquare.dms.domain.notice.application.port.outbound.FindNoticeByIdPort;
import app.xquare.dms.domain.notice.application.port.outbound.FindNoticePort;
import app.xquare.dms.domain.notice.application.port.outbound.SaveNoticePort;
import app.xquare.dms.domain.notice.domain.Notice;
import app.xquare.dms.domain.notice.exception.NoticeNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class NoticePersistenceAdaptor implements FindNoticePort, SaveNoticePort, FindNoticeByIdPort {

    private final NoticeRepository noticeRepository;

    private final NoticeMapper noticeMapper;

    @Override
    public List<Notice> findNotice() {
        return noticeRepository.findAll().stream()
                .map(noticeMapper::mapToNotice)
                .collect(Collectors.toList());
    }

    @Override
    public void saveNotice(Notice notice) {
        NoticeJpaEntity noticeJpaEntity = noticeMapper.mapToNoticeJpaEntity(notice);

        noticeRepository.save(noticeJpaEntity);
    }

    @Override
    public Notice findNoticeById(String id) {
        NoticeJpaEntity notice = noticeRepository.findById(id)
                .orElseThrow(() -> NoticeNotFoundException.EXCEPTION);

        return noticeMapper.mapToNotice(notice);
    }
}
