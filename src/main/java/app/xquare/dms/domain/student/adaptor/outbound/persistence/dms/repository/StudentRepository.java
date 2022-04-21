package app.xquare.dms.domain.student.adaptor.outbound.persistence.dms.repository;

import app.xquare.dms.domain.student.adaptor.outbound.persistence.dms.entity.StudentJpaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<StudentJpaEntity, String> {
}
