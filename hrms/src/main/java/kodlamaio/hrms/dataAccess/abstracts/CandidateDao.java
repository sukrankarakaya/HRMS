package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.core.utilities.result.DataResult;
import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concrate.Candidate;

public interface CandidateDao extends JpaRepository<Candidate,Integer> {
	
	Candidate getByEmail(String email);
	Candidate getByIdentityNumber(String identityNumber);
	Candidate getById(int id);
}
