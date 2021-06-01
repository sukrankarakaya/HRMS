package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concrate.Candidate;

public interface CandidateService {
	
	DataResult<List<Candidate>> getAll();
	Result add(Candidate candidate);
	Result delete(int  id );

}
