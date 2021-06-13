package kodlamaio.hrms.business.adapters;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.entities.concrate.Employer;

@Service
public class EmailVerification {
	public boolean checkEmail(String email) {

		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
		
	}
	 private Result checkEmailIsDomain(Employer employer) {

	        String[] isEmailCompatible = employer.getEmail().split("@", 2); // @ işaretinden iki ayrı parçaya böler
	        String webAdress = employer.getEmail() .substring(4); // www. kısmından sonrasını alır

	        if (!isEmailCompatible[1].equals(webAdress)){
	            return new ErrorResult("Email adresi web sitenizle aynı domain'e sahip olmalıdır.");
	        }

	        return new SuccessResult();
	    }
	
	
	

}
