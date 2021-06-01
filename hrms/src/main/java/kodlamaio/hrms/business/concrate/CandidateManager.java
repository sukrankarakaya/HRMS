package kodlamaio.hrms.business.concrate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.adapters.FakeMernis;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concrate.Candidate;

@Service
public class CandidateManager implements CandidateService{

	private CandidateDao candidateDao;
	private FakeMernis fakeMernis;
	private UserDao userDao;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, FakeMernis fakeMernis,UserDao userDao) {
		super();
		this.userDao=userDao;
		this.candidateDao = candidateDao;
		this.fakeMernis = fakeMernis;
	}

	
	

	@Override
	public DataResult<List<Candidate>> getAll() {
		
		
		return new SuccessDataResult<List<Candidate>> (this.candidateDao.findAll(),"Adaylar Listelendi");
				
	}

	@Override
	public Result add(Candidate candidate) {
		
		if(candidate.getFirstName().isEmpty() || candidate.getFirstName().equals("string")||
				candidate.getLastName().isEmpty() || candidate.getLastName().equals("string")||
				candidate.getBirthdate().toString().isEmpty() || candidate.getBirthdate().equals("string")||
				candidate.getPassword().isEmpty() || candidate.getPassword().equals("string")||
				candidate.getIsChackPassword().isEmpty() || candidate.getIsChackPassword().equals("string")||
				candidate.getEmail().isEmpty() || candidate.getEmail().equals("string")||
				candidate.getIdentityNumber().isEmpty() || candidate.getIdentityNumber().equals("string")) {
			
			return new ErrorResult("Lütfen formu eksiksiz doldurun.");
			
		}
		else if(!candidate.getPassword().equals(candidate.getIsChackPassword()))  {
			return new ErrorResult("Şifre Tekrarı yanliş.");
			
		}
		
		else if(!fakeMernis.checkMernis(candidate.getIdentityNumber())) {
			return new ErrorResult("Gerçek olmayan Kişi.");
		}
		
		else if(candidateDao.getByEmail(candidate.getEmail())!=null &&
				candidateDao.getByIdentityNumber(candidate.getIdentityNumber())!=null) {
			
			return new ErrorResult("Email adresi sisteme kayıtlı.");
		}
		
		else {

			this.candidateDao.save(candidate);
			return new SuccessDataResult("Yeni Aday Eklendi.");
			
		}
	}

	@Override
	public Result delete(int id) {

		this.candidateDao.deleteById(id);
		return new SuccessDataResult("Aday silindi.");
		
	}

	

}
