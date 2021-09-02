package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concrate.CandidateCoverLetter;
import kodlamaio.hrms.entities.concrate.CandidateLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concrate.Experience;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExperienceDao extends JpaRepository<Experience,Integer>{
    Experience getById(int id);


    @Query("From Experience where  candidate.id=:id")
    Experience getBy_CandidateId(int id);

}
