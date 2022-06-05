package app.xquare.dms.domain.notice.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
public class Notice {

    private final String id;

    @Setter
    private String title;

    @Setter
    private String content;

    private final LocalDateTime createdAt;
}
