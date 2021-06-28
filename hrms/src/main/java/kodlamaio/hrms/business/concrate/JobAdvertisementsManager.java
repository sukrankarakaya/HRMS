package kodlamaio.hrms.business.concrate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import net.bytebuddy.asm.Advice.This;

@Service
public class JobAdvertisementsManager implements JobAdvertisementService{

	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementsManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public Result add(JobAdvertisements jobAdertisement) {
		/*if(!checkIfNullField(jobAdertisement)) {
			return new ErrorResult("Lütfen zorunlu alanları doldurunuz.");
		}
		else {

			this.jobAdvertisementDao.save(jobAdertisement);
			return new SuccessResult("İş ilanı eklendi.");
		}*/


		this.jobAdvertisementDao.save(jobAdertisement);
		return new SuccessResult("İş ilanı eklendi.");
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
		return new SuccessDataResult<JobAdvertisements>(this.jobAdvertisementDao.getOne(id));
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
	public Result update(JobAdvertisements jobAdertisement) {
		this.jobAdvertisementDao.save(jobAdertisement);
		return new SuccessResult("İş ilanı güncellendi.");
	}
	/*@Override
	public DataResult<List<JobAdvertisementDto>> getJobAdvertisementDetails() {
	
		return new SuccessDataResult<List<JobAdvertisementDto>>
		(this.jobAdvertisementDao.getJobAdvertisementDetails()," iş ilnları listelendi. ");

	
	}*/

	


	

}
