package kodlamaio.hrms.business.concrate;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.VerificationCodeService;
import kodlamaio.hrms.core.utilities.result.Result;

import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.VerificationCodeDao;

import kodlamaio.hrms.entities.concrate.VerificationCode;

@Service
public class VerificationCodeManager implements VerificationCodeService{

	private VerificationCodeDao verificationCodeDao;
	
	@Autowired
	public VerificationCodeManager(VerificationCodeDao verificationCodeDao) {
		super();
		this.verificationCodeDao = verificationCodeDao;
	}

	@Override
	public Result add(VerificationCode verificationCode) {
		this.verificationCodeDao.save(verificationCode);
	
		return new SuccessResult("Code Eklendi.");
	}

	@Override
	public String sendCode() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Result add(VerificationCode verificationCode) {
//		
//		UUID uuid = UUID.randomUUID();
//		this.verificationCodeDao.save(verificationCode);
//		return new SuccessDataResult("Code eklendi.");
//	}
//
//	@Override
//	public String sendCode() {
//		UUID uuid = UUID.randomUUID();
//		String verificationCode = uuid.toString();
//		System.out.println("kod kaydedildi: " + verificationCode );
//		return verificationCode;
//	}
//
//	
	
	
}
