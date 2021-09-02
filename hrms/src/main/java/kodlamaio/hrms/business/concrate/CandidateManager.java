package kodlamaio.hrms.business.concrate;

import java.util.List;
import java.util.UUID;

import kodlamaio.hrms.business.abstracts.*;
import kodlamaio.hrms.core.utilities.result.*;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCoverLetterDao;
import kodlamaio.hrms.entities.concrate.CandidateCoverLetter;
import kodlamaio.hrms.entities.concrate.CandidateLanguage;
import kodlamaio.hrms.entities.dtos.CvDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kodlamaio.hrms.business.adapters.FakeMernis;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.dataAccess.abstracts.VerificationCodeDao;
import kodlamaio.hrms.entities.concrate.Candidate;
import org.springframework.web.bind.annotation.RequestParam;


@Service
public class CandidateManager implements CandidateService{

	private CandidateDao candidateDao;
	private FakeMernis fakeMernis;

	private ExperienceService experienceService;
	private CandidateLanguageService candidateLanguageService;
	private CandidateImageService candidateImageService;
	private SocialMediaService socialMediaService;
	private TechnologyService technologyService;
	private CandidateSchoolService candidateSchoolService;
	private CandidateCoverLetterService candidateCoverLetterService;

	
	

	@Autowired
	public CandidateManager(CandidateDao candidateDao, FakeMernis fakeMernis, UserDao userDao,VerificationCodeDao verificationCodeDao, VerificationCodeService verificationCodeService,
							ExperienceService experienceService, CandidateLanguageService candidateLanguageService,CandidateImageService candidateImageService,
							SocialMediaService socialMediaService, TechnologyService technologyService,CandidateSchoolService candidateSchoolService,
							CandidateCoverLetterService candidateCoverLetterService) {
		super();
		this.candidateDao = candidateDao;

		this.fakeMernis = fakeMernis;

		this.experienceService=experienceService;
		this.candidateLanguageService=candidateLanguageService;
		this.candidateImageService=candidateImageService;
		this.socialMediaService=socialMediaService;
		this.technologyService=technologyService;
		this.candidateSchoolService=candidateSchoolService;
		this.candidateCoverLetterService= candidateCoverLetterService;
	}
	

	@Override
	public DataResult<List<Candidate>> getAll() {
		
		
		return new SuccessDataResult<List<Candidate>> (this.candidateDao.findAll(),"Adaylar Listelendi");
				
	}

	@Override
	public Result add(Candidate candidate) {
		
		if(candidate.getFirstName().isEmpty() || candidate.getFirstName().equals("string")||
				candidate.getLastName().isEmpty() || candidate.getLastName().equals("string")||
				candidate.getBirthDate().toString().isEmpty() || candidate.getBirthDate().equals("string")||
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
	public Result update(Candidate candidate) {
		Candidate candidate1 = this.candidateDao.getById(candidate.getId());
		candidate1.setFirstName(candidate.getFirstName());
		candidate1.setLastName(candidate.getLastName());
		candidate1.setBirthDate(candidate.getBirthDate());
		candidate1.setEmail(candidate.getEmail());
		this.candidateDao.save(candidate1);
		return new SuccessResult(" Bilgiler Güncellendi");
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

	@Override
	public DataResult<Candidate> getById(int id) {
		return new SuccessDataResult<Candidate>(this.candidateDao.getById(id));
	}

//	@Override
//	public DataResult<CvDto> getCandidateCVById(int id) {
//
//		Candidate candidate =this.candidateDao.getById(id);
//		CvDto cv=new CvDto();
//		cv.experiences=candidate.getExperience();
//		cv.candidateLanguages=candidate.getCandidateLanguages();
//		cv.candidateImage=candidate.getCandidateImage();
//		cv.socialMedia=candidate.getSocialMedia();
//		cv.technologies=candidate.getTechnologies();
//		cv.candidateSchool=candidate.getCandidateSchools();
//		cv.candidateCoverLetter=candidate.getCandidateCoverLetters();
//
//		return new SuccessDataResult<CvDto>
//
//				(this.candidateDao.getCandidateCVById(id));
//	}


	@Override
	public DataResult<CvDto> getCandidateCVById(int id) {



		Candidate candidate =this.candidateDao.getById(id);
		CvDto cv=new CvDto();
		cv.candidate=candidateDao.getById(id);
		cv.experiences=candidate.getExperience();
		cv.candidateLanguages=candidate.getCandidateLanguages();
		cv.candidateImage=candidate.getCandidateImage();
		cv.socialMedia=candidate.getSocialMedia();
		cv.technologies=candidate.getTechnologies();
		cv.candidateSchool=candidate.getCandidateSchools();
		cv.candidateCoverLetter=candidate.getCandidateCoverLetters();

 	return new SuccessDataResult<CvDto>(cv);

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
