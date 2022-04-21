package app.xquare.dms.domain.student.adaptor.outbound.persistence.dms.repository;

import app.xquare.dms.domain.student.adaptor.outbound.persistence.dms.entity.PointStatusJpaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointStatusRepository extends CrudRepository<PointStatusJpaEntity, String> {
}
