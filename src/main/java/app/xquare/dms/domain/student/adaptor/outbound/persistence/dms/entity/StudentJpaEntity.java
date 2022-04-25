package app.xquare.dms.domain.student.adaptor.outbound.persistence.dms.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "student")
@Entity
public class StudentJpaEntity {

    @Id
    private String id;

    private String name;

    private String number;

    @OneToOne(mappedBy = "student", optional = false, fetch = FetchType.LAZY)
    private PointStatusJpaEntity pointStatus;
}
