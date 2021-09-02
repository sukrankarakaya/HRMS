package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;

import kodlamaio.hrms.entities.concrate.CandidateLanguage;
import kodlamaio.hrms.entities.concrate.CandidateSchool;
import kodlamaio.hrms.entities.concrate.Experience;

public interface ExperienceService {
	Result add(Experience experience);
	Result update(Experience experience);

	Result delete(int id);
	DataResult<List<Experience>> getAll();

	DataResult<Experience> getByCandidateId(int id);
}
