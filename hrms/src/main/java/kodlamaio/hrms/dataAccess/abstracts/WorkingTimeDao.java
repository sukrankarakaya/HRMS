package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concrate.WorkingTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkingTimeDao extends JpaRepository<WorkingTime, Integer> {
}
