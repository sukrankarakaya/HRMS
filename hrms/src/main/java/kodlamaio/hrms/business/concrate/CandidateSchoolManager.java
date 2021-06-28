package kodlamaio.hrms.business.concrate;

import kodlamaio.hrms.business.abstracts.CandidateSchoolService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateLanguageDao;
import kodlamaio.hrms.dataAccess.abstracts.CandidateSchoolDao;
import kodlamaio.hrms.entities.concrate.CandidateLanguage;
import kodlamaio.hrms.entities.concrate.CandidateSchool;
import kodlamaio.hrms.entities.concrate.JobAdvertisements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class CandidateSchoolManager implements CandidateSchoolService {

    private CandidateSchoolDao candidateSchoolDao;


    @Autowired
    public CandidateSchoolManager(CandidateSchoolDao candidateSchoolDao) {
        super();
        this.candidateSchoolDao = candidateSchoolDao;
    }



    @Override
    public Result add(CandidateSchool candidateSchool) {

        this.candidateSchoolDao.save(candidateSchool);
        return new SuccessResult("Okul Bilgisi Eklendi.");

    }

    @Override
    public DataResult<List<CandidateSchool>> getAll() {
        return new SuccessDataResult
                (this.candidateSchoolDao.findAll(),"Adayların okul bilgisi listelendi");
    }

    @Override
    public DataResult<List<CandidateSchool>> getByEndDateDesc() {
        Sort sort =Sort.by(Sort.Direction.DESC, "endDate");
        return new SuccessDataResult<List<CandidateSchool>>
                (this.candidateSchoolDao.findAll(sort),"Mezuniyet tarihlerine göre okul bilgileiri listelendi.");
    }
}
