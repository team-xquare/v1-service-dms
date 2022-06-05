package app.xquare.dms.domain.notice.adaptor.outbound.persistence.dms.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "notice")
@Entity
public class NoticeJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String title;

    private String content;

    @Column(name = "post_date")
    private LocalDateTime createdAt;
}
