package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concrate.CandidateCoverLetter;
import kodlamaio.hrms.entities.concrate.CandidateLanguage;
import kodlamaio.hrms.entities.concrate.Technologies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TechnologyDao extends JpaRepository<Technologies, Integer> {
    Technologies getById(int id);


    @Query("From Technologies where  candidate.id=:id")
    Technologies getBy_CandidateId(int id);

}
