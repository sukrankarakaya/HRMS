package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concrate.CandidateCoverLetter;
import kodlamaio.hrms.entities.concrate.CandidateLanguage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CandidateLanguageDao extends JpaRepository<CandidateLanguage, Integer> {
    CandidateLanguage getById(int id);


    @Query("From CandidateLanguage where  candidate.id=:id")
    CandidateLanguage getBy_CandidateId(int id);


}
