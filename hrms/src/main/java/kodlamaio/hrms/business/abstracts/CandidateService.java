package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concrate.Candidate;
import kodlamaio.hrms.entities.dtos.CvDto;

public interface CandidateService {
	
	DataResult<List<Candidate>> getAll();
	Result add(Candidate candidate);
	Result delete(int  id );
	public boolean validWtihMail(String email);
	public String code(String Code);

	DataResult<Candidate> getById(int id);

	DataResult<CvDto> getCandidateCVById(int id);

}
