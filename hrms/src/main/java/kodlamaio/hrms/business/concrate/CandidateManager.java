package kodlamaio.hrms.business.concrate;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.VerificationCodeService;
import kodlamaio.hrms.business.adapters.FakeMernis;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.dataAccess.abstracts.VerificationCodeDao;
import kodlamaio.hrms.entities.concrate.Candidate;
import kodlamaio.hrms.entities.concrate.VerificationCode;


@Service
public class CandidateManager implements CandidateService{

	private CandidateDao candidateDao;
	private FakeMernis fakeMernis;
	private UserDao userDao;
	private VerificationCodeDao verificationCodeDao;
	private VerificationCodeService verificationCodeService; 
	
	

	@Autowired
	public CandidateManager(CandidateDao candidateDao, FakeMernis fakeMernis, UserDao userDao,VerificationCodeDao verificationCodeDao, VerificationCodeService verificationCodeService) {
		super();
		this.candidateDao = candidateDao;
		this.fakeMernis = fakeMernis;
		this.userDao = userDao;
		this.verificationCodeDao=verificationCodeDao;
		this.verificationCodeService=verificationCodeService;
		
		
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
		
//		else if(activationCodeCandidateService.validWtihMail(candidate.getEmail())==false) {
//			
//			return new ErrorResult("Email dogrulanmadı."); 
//		}
		else {

			
			
			this.candidateDao.save(candidate);
//			String code =verificationCodeService.sendCode();
//			verificationCodeRecord(code, candidate.getId(), candidate.getEmail());			
			return new SuccessDataResult("Yeni Aday Eklendi.");
			
		}
	}

	@Override
	public Result delete(int id) {

		this.candidateDao.deleteById(id);
		return new SuccessDataResult("Aday silindi.");
		
	}






	@Override
	public boolean validWtihMail(String email) {
		return true;
	}


	@Override
	public String code(String Code) {
		UUID uuid = UUID.randomUUID();
		String code = uuid.toString();
		return code;
	}
	
	UUID uuid = UUID.randomUUID();
	String code = uuid.toString();
	
	
//	private void verificationCodeRecord(String code, int useId, String email) {
//		
//		VerificationCode verificationCode = new VerificationCode(useId, code, false);
//		this.verificationCodeService.add(verificationCode);
//		System.out.println("Verification code has been sent to " + email );
//	
//	}
	
	
	

	

}
