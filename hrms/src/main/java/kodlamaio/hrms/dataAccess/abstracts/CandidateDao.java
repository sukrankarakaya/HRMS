package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.entities.dtos.CvDto;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;
import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concrate.Candidate;
import org.springframework.data.jpa.repository.Query;

public interface CandidateDao extends JpaRepository<Candidate,Integer> {
	
	Candidate getByEmail(String email);
	Candidate getByIdentityNumber(String identityNumber);
	Candidate getById(int id);

//	@Query("Select new kodlamaio.hrms.entities.dtos.CvDto"
//			+ "( c.firstName,c.lastName, c.email,c.birthDate,e.workPlace, e.position,e.startDate,e.endDate,i.imageUrl,l.language,s.SchoolName, s.department, s.startDate,s.endDate, sm.githubLink,sm.linkedinLink,t.technologyName,co.coverLetter) "
//			+ "From Candidate c Inner Join c.experience e Inner Join c.socialMedia sm  Inner Join c.candidateImage i Inner Join c.candidateLanguages l  Inner Join c.candidateSchools s Inner Join c.technologies t Inner Join c.candidateCoverLetters co   where c.id=:id ")
//	CvDto getCandidateCVById(int id);

}
