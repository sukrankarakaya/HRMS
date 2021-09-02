package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concrate.Technologies;
import kodlamaio.hrms.entities.concrate.WayOfWorking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WayOfWorkingDao extends JpaRepository<WayOfWorking, Integer> {
}
