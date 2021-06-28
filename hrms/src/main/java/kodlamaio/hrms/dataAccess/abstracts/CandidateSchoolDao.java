package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concrate.CandidateSchool;
import kodlamaio.hrms.entities.concrate.JobAdvertisements;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidateSchoolDao extends JpaRepository<CandidateSchool, Integer> {


    @Query("From CandidateSchool order by endDate Desc  ")
    List<CandidateSchool> getByEndDateDesc(Data endDate);

}
