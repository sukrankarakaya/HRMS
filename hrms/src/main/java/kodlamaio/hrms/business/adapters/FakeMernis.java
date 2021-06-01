package kodlamaio.hrms.business.adapters;

import org.springframework.stereotype.Service;
@Service
public class FakeMernis {

	
	public boolean checkMernis( String identityNumber) {
		
		
		
		if(identityNumber.length()!=11 ) {
			System.out.println("Kişi dogrulanamadı.");
			return false;
		}
		
		else {
			System.out.println("Mernis Dogrulamasından geçtniz");
			return true;
		}
		
	}
}
