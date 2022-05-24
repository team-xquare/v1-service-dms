package app.xquare.dms.domain.student.adaptor.outbound.persistence.dms.repository;

import app.xquare.dms.domain.student.adaptor.outbound.persistence.dms.entity.StudentJpaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<StudentJpaEntity, String> {

    @Query("select s from StudentJpaEntity s join fetch s.pointStatus join fetch s.stayApply join fetch s.mealApply order by s.number")
    public List<StudentJpaEntity> findAllOrderByStudentNumber();
}
