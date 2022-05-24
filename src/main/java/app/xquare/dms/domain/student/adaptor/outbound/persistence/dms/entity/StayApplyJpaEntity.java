package app.xquare.dms.domain.student.adaptor.outbound.persistence.dms.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "stay_apply")
@Entity
public class StayApplyJpaEntity {

    @Id
    @Column(name = "student_id")
    private String id;

    @MapsId("id")
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private StudentJpaEntity student;

    private Integer value;
}
