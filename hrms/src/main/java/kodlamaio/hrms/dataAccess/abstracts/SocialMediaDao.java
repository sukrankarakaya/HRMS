package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concrate.CandidateCoverLetter;
import kodlamaio.hrms.entities.concrate.CandidateLanguage;
import kodlamaio.hrms.entities.concrate.SocialMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SocialMediaDao extends JpaRepository<SocialMedia, Integer> {
    SocialMedia getById(int id);


    @Query("From SocialMedia where  candidate.id=:id")
    SocialMedia getBy_CandidateId(int id);

}
