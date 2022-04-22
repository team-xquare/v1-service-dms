package app.xquare.dms.domain.student.adaptor.outbound.persistence.dms.repository;

import app.xquare.dms.domain.student.adaptor.outbound.persistence.dms.entity.PointJpaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointRepository extends CrudRepository<PointJpaEntity, String> {

    List<PointJpaEntity> findAll();
}
