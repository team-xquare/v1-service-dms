package app.xquare.dms.domain.student.adaptor.outbound.persistence.dms.repository;

import app.xquare.dms.domain.student.adaptor.outbound.persistence.dms.entity.PointHistoryJpaEntity;
import app.xquare.dms.domain.student.adaptor.outbound.persistence.dms.entity.StudentJpaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointHistoryRepository extends CrudRepository<PointHistoryJpaEntity, String> {

    @Query("select p from PointHistoryJpaEntity p join fetch p.point where p.student = :student order by p.pointDate desc")
    List<PointHistoryJpaEntity> findByStudent(@Param("student") StudentJpaEntity student);
}
