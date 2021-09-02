package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concrate.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResumeDao extends JpaRepository<Resume,Integer> {

    Resume getByCandidateId(int id);

}
