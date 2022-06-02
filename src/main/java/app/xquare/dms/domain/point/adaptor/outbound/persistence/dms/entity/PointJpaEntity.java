package app.xquare.dms.domain.point.adaptor.outbound.persistence.dms.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "point_item")
@Entity
public class PointJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String reason;

    private Boolean type;

    private Integer point;
}
