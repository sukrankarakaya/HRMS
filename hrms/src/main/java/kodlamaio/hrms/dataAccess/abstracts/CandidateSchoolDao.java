package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concrate.CandidateCoverLetter;
import kodlamaio.hrms.entities.concrate.CandidateLanguage;
import kodlamaio.hrms.entities.concrate.CandidateSchool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidateSchoolDao extends JpaRepository<CandidateSchool, Integer> {
    CandidateSchool getById(int id);


    @Query("From CandidateSchool where  candidate.id=:id")
    List<CandidateSchool> getBy_CandidateId(int id);

}
