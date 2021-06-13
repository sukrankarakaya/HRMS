package kodlamaio.hrms.business.concrate;

import java.util.List;
//
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;

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

}
