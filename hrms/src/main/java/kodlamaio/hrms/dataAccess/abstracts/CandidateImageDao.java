package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concrate.CandidateCoverLetter;
import kodlamaio.hrms.entities.concrate.CandidateImage;
import kodlamaio.hrms.entities.concrate.CandidateLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidateImageDao  extends JpaRepository<CandidateImage,Integer> {
    CandidateImage getById(int id);


    @Query("From CandidateImage where  candidate.id=:id")
    CandidateImage getBy_CandidateId(int id);



}
