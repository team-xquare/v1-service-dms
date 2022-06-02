package app.xquare.dms.domain.point.adaptor.outbound.persistence.dms.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "point_item")
@Entity
public class PointJpaEntity {

    @Id
    private String id;

    private String reason;

    private Boolean type;

    private Integer point;
}
