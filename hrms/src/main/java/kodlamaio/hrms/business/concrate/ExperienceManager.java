package kodlamaio.hrms.business.concrate;

import java.util.List;

import kodlamaio.hrms.entities.concrate.CandidateSchool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ExperienceDao;
import kodlamaio.hrms.entities.concrate.Experience;

@Service
public class ExperienceManager implements ExperienceService {

	private ExperienceDao experienceDao;
	
	@Autowired
	public ExperienceManager(ExperienceDao experienceDao) {
		super();
		this.experienceDao = experienceDao;
	}

	@Override
	public Result add(Experience experience) {

		this.experienceDao.save(experience);
		return new SuccessResult("Deneyim eklendi.");
	}

	@Override
	public DataResult<List<Experience>> getAll() {
		return new SuccessDataResult<List<Experience>>(this.experienceDao.findAll(),"Deneyimler listelendi.");

	}

	@Override
	public DataResult<List<Experience>> getByEndDateDesc() {
		Sort sort =Sort.by(Sort.Direction.DESC, "endDate");
		return new SuccessDataResult<List<Experience>>
				(this.experienceDao.findAll(sort),"İşten ayrılma tarih bilgileirinegore listelendi.");
	}

}
