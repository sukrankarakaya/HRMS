package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;

import kodlamaio.hrms.entities.concrate.CandidateSchool;
import kodlamaio.hrms.entities.concrate.Experience;

public interface ExperienceService {
	Result add(Experience experience);

	DataResult<List<Experience>> getAll();

	DataResult<List<Experience> >getByEndDateDesc();
}
