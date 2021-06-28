package kodlamaio.hrms.dataAccess.abstracts;


import kodlamaio.hrms.entities.concrate.CandidateCoverLetter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateCoverLetterDao extends JpaRepository<CandidateCoverLetter, Integer> {
}
