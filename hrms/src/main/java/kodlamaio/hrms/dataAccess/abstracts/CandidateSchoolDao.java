package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concrate.CandidateSchool;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateSchoolDao extends JpaRepository<CandidateSchool, Integer> {
}
