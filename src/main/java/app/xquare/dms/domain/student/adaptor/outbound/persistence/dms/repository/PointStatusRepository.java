package app.xquare.dms.domain.student.adaptor.outbound.persistence.dms.repository;

import app.xquare.dms.domain.student.adaptor.outbound.persistence.dms.entity.PointStatusJpaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointStatusRepository extends CrudRepository<PointStatusJpaEntity, String> {

    @Query("select p from PointStatusJpaEntity p join fetch p.student order by p.student.number")
    List<PointStatusJpaEntity> findAllOrderByStudentNumber();
}
