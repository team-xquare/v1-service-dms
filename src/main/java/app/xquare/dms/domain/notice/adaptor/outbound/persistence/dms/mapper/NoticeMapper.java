package app.xquare.dms.domain.notice.adaptor.outbound.persistence.dms.mapper;

import app.xquare.dms.domain.notice.adaptor.outbound.persistence.dms.entity.NoticeJpaEntity;
import app.xquare.dms.domain.notice.domain.Notice;
import org.springframework.stereotype.Component;

@Component
public class NoticeMapper {

    public Notice mapToNotice(NoticeJpaEntity notice) {
        return Notice.builder()
                .id(notice.getId())
                .title(notice.getTitle())
                .content(notice.getContent())
                .createdAt(notice.getCreatedAt())
                .build();
    }
}
