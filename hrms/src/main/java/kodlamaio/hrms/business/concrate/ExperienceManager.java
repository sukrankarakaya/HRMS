package kodlamaio.hrms.business.concrate;

import java.util.List;

import kodlamaio.hrms.entities.concrate.CandidateImage;
import kodlamaio.hrms.entities.concrate.SocialMedia;
import org.springframework.beans.factory.annotation.Autowired;
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
	public Result update(Experience experience) {
		Experience exper= this.experienceDao.getById(experience.getId());
		exper.setWorkPlace(experience.getWorkPlace());
		exper.setPosition(experience.getPosition());
		exper.setStartDate(experience.getStartDate());
		exper.setEndDate(experience.getEndDate());
		this.experienceDao.save(exper);
		return new SuccessResult("Deneyim Bilgisi Güncellendi");
	}

	@Override
	public Result delete(int id) {
		this.experienceDao.deleteById(id);
		return new SuccessResult("İş Deneyim Bilgisi Silindi.");
	}




	@Override
	public DataResult<List<Experience>> getAll() {
		return new SuccessDataResult<List<Experience>>(this.experienceDao.findAll(),"Deneyimler listelendi.");

	}

	@Override
	public DataResult<Experience> getByCandidateId(int id) {
		return new SuccessDataResult<Experience>
				( this.experienceDao.getBy_CandidateId(id));
	}

}
