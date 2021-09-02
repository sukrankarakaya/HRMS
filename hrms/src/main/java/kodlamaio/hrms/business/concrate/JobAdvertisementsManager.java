package kodlamaio.hrms.business.concrate;

import java.util.List;

import kodlamaio.hrms.entities.dtos.JobAdventisamentFilterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concrate.JobAdvertisements;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

@Service
public class JobAdvertisementsManager implements JobAdvertisementService{

	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementsManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public Result delete(int id) {
		this.jobAdvertisementDao.deleteById(id);
		return new SuccessDataResult("İş ilanı silindi.");
	}

	@Override
	public Result add(JobAdvertisements jobAdertisement) {
		if(!checkIfNullField(jobAdertisement)) {
			return new ErrorResult("Lütfen zorunlu alanları doldurunuz.");
		}
		else {

			this.jobAdvertisementDao.save(jobAdertisement);
			return new SuccessResult("İş ilanı eklendi.");
		}

	}

	public boolean checkIfNullField(JobAdvertisements jobAdvertisement) {
	        if (jobAdvertisement.getJobDesciription()!=null&& jobAdvertisement.getCities().getId()!=0
	                &&jobAdvertisement.getNumberOfPosition()!=0&& jobAdvertisement.getJobPosition()!=null){
	            return true;
	        }
	        return false;
	    }

	@Override
	public DataResult<List<JobAdvertisements>> getByActiveTrue() {
		return new SuccessDataResult<List<JobAdvertisements>>(this.jobAdvertisementDao.getByActiveTrue(),"Aktif olan iş ilanları listelendi.");
	}

	
	@Override
	public DataResult<List<JobAdvertisements>> getByActiveAndByCreateDateDesc() {
		Sort sort =Sort.by(Sort.Direction.DESC, "createDate");
		return new SuccessDataResult<List<JobAdvertisements>>
		(this.jobAdvertisementDao.findAll(sort),"Aktif olan iş ilanları yayınlanış tarihine göre sıralandı.");
	}

	@Override
	public DataResult<List<JobAdvertisements>> getByActiveAndEmployerId(int id) {
		return new SuccessDataResult<List<JobAdvertisements>>
		(this.jobAdvertisementDao.getByActiveAndEmployer_EmployerId(id),"İşveren id'sine göre iş ilnları listelendi. ");
	}

	@Override
	public DataResult<JobAdvertisements> getById(int id) {
		return new SuccessDataResult<JobAdvertisements>(this.jobAdvertisementDao.getById(id));
	}

	@Override
	public Result changeActiveToClose(int id) {
		if(getById(id)==null) {
			return new ErrorResult("İş ilanını giriniz.");
		}
		if(getById(id).getData().isActive()==false) {
			return new  ErrorResult("Zaten aktif degil.");
		}
		
		JobAdvertisements jobAdvertisement= getById(id).getData();
		jobAdvertisement.setActive(false);
		update(jobAdvertisement);
		return new SuccessResult("İş ilanı pasifleştirildi.");
		
	}

	@Override
	public Result changeActiveToCloseTrue(int id) {
		if(getById(id)==null) {
			return new ErrorResult("İş ilanını giriniz.");
		}
		if(getById(id).getData().isActive()==true) {
			return new  ErrorResult("Zaten aktif.");
		}

		JobAdvertisements jobAdvertisement= getById(id).getData();
		jobAdvertisement.setActive(true);
		update(jobAdvertisement);
		return new SuccessResult("İş ilanı aktifleştirildi.");

	}

	@Override
	public DataResult<List<JobAdvertisements>> getAll() {
		this.jobAdvertisementDao.findAll();
		return new SuccessDataResult("İş ilanları listelendi");
	}


	@Override
	public Result update(JobAdvertisements jobAdvertisement) {

		JobAdvertisements advertisement= this.jobAdvertisementDao.getById(jobAdvertisement.getId());
		advertisement.setJobDesciription(jobAdvertisement.getJobDesciription());
	 	advertisement.setCities(jobAdvertisement.getCities());
	 	advertisement.setEmployer(jobAdvertisement.getEmployer());
	 	advertisement.setJobPosition(jobAdvertisement.getJobPosition());
	 	advertisement.setCreateDate(jobAdvertisement.getCreateDate());
	 	advertisement.setDeadLine(jobAdvertisement.getDeadLine());
	 	advertisement.setMaxSalary(jobAdvertisement.getMaxSalary());
	 	advertisement.setMinSalary(jobAdvertisement.getMinSalary());
	 	advertisement.setNumberOfPosition(jobAdvertisement.getNumberOfPosition());
	 	advertisement.setWorkingTime(jobAdvertisement.getWorkingTime());
	 	advertisement.setWayOfWorking(jobAdvertisement.getWayOfWorking());

		this.jobAdvertisementDao.save(advertisement);
		return new SuccessResult("İş ilanı güncellendi.");
	}
	@Override
	public DataResult<List<JobAdvertisementDto>> getJobAdvertisementDetails() {
	
		return new SuccessDataResult<List<JobAdvertisementDto>>
		(this.jobAdvertisementDao.getJobAdvertisementDetails()," iş ilnları listelendi. ");

	
	}

	@Override
	public DataResult<JobAdvertisementDto> getJobAdvertisementDetailsById(int id) {
		return new SuccessDataResult<>
				(this.jobAdvertisementDao.getJobAdvertisementDetailsById(id), "İş İlanı deyatyı görüntülendi.");
	}

	@Override
	public DataResult<List<JobAdvertisements>> getFilter(int cityId, int positionId ,int workingTimeId, int wayOfWorkingId) {
		return  new SuccessDataResult(this.jobAdvertisementDao.getFilter(cityId,positionId,workingTimeId,wayOfWorkingId));
	}

	@Override
	public DataResult<List<JobAdvertisements>> getByFilter(JobAdventisamentFilterDto jobAdventisamentFilterDto, int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return new SuccessDataResult<List<JobAdvertisements>>(
				this.jobAdvertisementDao.getByFilter(jobAdventisamentFilterDto, pageable).getContent(),
				this.jobAdvertisementDao.getByFilter(jobAdventisamentFilterDto, pageable).getTotalPages() + "");


	}


}
