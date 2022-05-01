package app.xquare.dms.domain.student.adaptor.outbound.persistence.dms.repository;

import app.xquare.dms.domain.student.adaptor.outbound.persistence.dms.entity.PointHistoryJpaEntity;
import app.xquare.dms.domain.student.adaptor.outbound.persistence.dms.entity.StudentJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointHistoryRepository extends JpaRepository<PointHistoryJpaEntity, String> {

    @Query("select p from PointHistoryJpaEntity p join fetch p.point where p.student = :student order by p.pointDate desc")
    List<PointHistoryJpaEntity> findByStudent(@Param("student") StudentJpaEntity student);

    @Query("select p from PointHistoryJpaEntity p join fetch p.point join fetch p.student where p.student.number like :number order by p.student.number asc, p.pointDate desc")
    List<PointHistoryJpaEntity> findByStudentGrade(@Param("number") String number);
}
