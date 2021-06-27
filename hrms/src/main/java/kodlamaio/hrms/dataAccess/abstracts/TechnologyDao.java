package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concrate.Technologies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologyDao extends JpaRepository<Technologies, Integer> {
}
