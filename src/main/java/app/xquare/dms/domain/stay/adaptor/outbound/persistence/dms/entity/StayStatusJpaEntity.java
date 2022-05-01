package app.xquare.dms.domain.stay.adaptor.outbound.persistence.dms.entity;

import app.xquare.dms.domain.student.adaptor.outbound.persistence.dms.entity.StudentJpaEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "stay_apply")
@Entity
public class StayStatusJpaEntity {

    @Id
    @Column(name = "student_id")
    private String id;

    private Integer value;

    @MapsId("id")
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private StudentJpaEntity student;
}
