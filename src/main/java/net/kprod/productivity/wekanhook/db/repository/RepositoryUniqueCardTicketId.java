package net.kprod.productivity.wekanhook.db.repository;

import net.kprod.productivity.wekanhook.db.entity.EntityUniqueCardTicketId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kemkem on 4/26/18.
 */
@Repository
public interface RepositoryUniqueCardTicketId extends JpaRepository<EntityUniqueCardTicketId, Long>{
}
