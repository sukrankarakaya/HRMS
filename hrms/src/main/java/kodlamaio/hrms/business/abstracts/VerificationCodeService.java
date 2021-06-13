package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concrate.VerificationCode;

public interface VerificationCodeService {

	Result add(VerificationCode verificationCode);
	String sendCode();
}
