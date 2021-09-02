package kodlamaio.hrms.business.concrate;

import java.util.List;
//
import kodlamaio.hrms.core.utilities.result.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;

import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concrate.Employer;

@Service
public class EmpoloyerManager implements EmployerService {
	
	private EmployerDao employerDao;
	

	@Autowired
	public EmpoloyerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"iş Verenler Listelendi");
	}

	@Override
	public Result add(Employer employer) {
		if(
				employer.getPassword().isEmpty() || employer.getPassword().equals("string")||
				employer.getIsChackPassword().isEmpty() || employer.getIsChackPassword().equals("string")||
				employer.getEmail().isEmpty() || employer.getEmail().equals("string")) {
			
			return new ErrorResult("Lütfen formu eksiksiz doldurun.");
			
		}
		else if(!employer.getPassword().equals(employer.getIsChackPassword()))  {
			return new ErrorResult("Şifre tekrarı yanliş.");
			
		}		
		else if(employerDao.getByEmail(employer.getEmail())!=null) {
			
			return new ErrorResult("Email adresi sisteme kayıtlı.");
		}
		
		else {

			this.employerDao.save(employer);
			return new SuccessDataResult("Yeni işveren eklendi.");
			
		}
		
	}

	@Override
	public Result delete(int id) {
		this.employerDao.deleteById(id);
		return  new SuccessResult("Employer Silindi.");
	}

	@Override
	public Result update(Employer employer) {
		Employer employer1=this.employerDao.getById(employer.getId());
		employer1.setCompanyName(employer.getCompanyName());
		employer1.setWebAdress(employer.getWebAdress());
		employer1.setPhoneNumber(employer.getPhoneNumber());
		employer1.setEmail(employer.getEmail());
		this.employerDao.save(employer1);
		return  new SuccessResult("Bilgiler Güncellendi.");
	}

	@Override
	public DataResult<Employer> getById(int id) {
		return  new SuccessDataResult<>(this.employerDao.getById(id));
	}

}
