package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concrate.CandidateCoverLetter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidateCoverLetterDao extends JpaRepository<CandidateCoverLetter, Integer> {
    CandidateCoverLetter getById(int id);


    @Query("From CandidateCoverLetter where  candidate.id=:id")
    CandidateCoverLetter getBy_CandidateId(int id);

}
