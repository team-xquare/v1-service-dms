package app.xquare.dms.domain.notice.adaptor.outbound.persistence.dms;

import app.xquare.dms.domain.notice.adaptor.outbound.persistence.dms.mapper.NoticeMapper;
import app.xquare.dms.domain.notice.adaptor.outbound.persistence.dms.repository.NoticeRepository;
import app.xquare.dms.domain.notice.application.port.outbound.FindNoticePort;
import app.xquare.dms.domain.notice.domain.Notice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class NoticePersistenceAdaptor implements FindNoticePort {

    private final NoticeRepository noticeRepository;

    private final NoticeMapper noticeMapper;

    @Override
    public List<Notice> findNotice() {
        return noticeRepository.findAll().stream()
                .map(noticeMapper::mapToNotice)
                .collect(Collectors.toList());
    }
}
