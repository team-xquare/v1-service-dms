package app.xquare.dms.domain.student.adaptor.outbound.persistence.dms.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "point_status")
@Entity
public class PointStatusJpaEntity {

    @Id
    @Column(name = "student_id")
    private String id;

    private Integer goodPoint;

    private Integer badPoint;

    private Integer penaltyLevel;

    private Boolean penaltyStatus;

    @MapsId("id")
    @OneToOne
    @JoinColumn(name = "student_id", nullable = false)
    private StudentJpaEntity student;
}
