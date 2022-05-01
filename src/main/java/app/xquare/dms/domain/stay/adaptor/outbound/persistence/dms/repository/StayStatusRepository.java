package app.xquare.dms.domain.stay.adaptor.outbound.persistence.dms.repository;

import app.xquare.dms.domain.stay.adaptor.outbound.persistence.dms.entity.StayStatusJpaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StayStatusRepository extends CrudRepository<StayStatusJpaEntity, String> {

    @Query("select s from StayStatusJpaEntity s join fetch s.student order by s.student.number")
    List<StayStatusJpaEntity> findAll();
}
