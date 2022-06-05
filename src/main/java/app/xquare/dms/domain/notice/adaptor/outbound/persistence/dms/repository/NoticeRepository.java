package app.xquare.dms.domain.notice.adaptor.outbound.persistence.dms.repository;

import app.xquare.dms.domain.notice.adaptor.outbound.persistence.dms.entity.NoticeJpaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends CrudRepository<NoticeJpaEntity, String> {

    @Query("select n from NoticeJpaEntity n order by n.createdAt desc")
    List<NoticeJpaEntity> findAll();
}
