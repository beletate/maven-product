package univas.edu.vinicius.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import univas.edu.vinicius.model.Auditing;

@Repository
public interface AuditingDAO extends JpaRepository<Auditing, Long>{

}
