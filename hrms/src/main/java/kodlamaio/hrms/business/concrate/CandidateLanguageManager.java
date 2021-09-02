package kodlamaio.hrms.business.concrate;

import kodlamaio.hrms.business.abstracts.CandidateLanguageService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateLanguageDao;
import kodlamaio.hrms.entities.concrate.CandidateCoverLetter;
import kodlamaio.hrms.entities.concrate.CandidateLanguage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateLanguageManager implements CandidateLanguageService {

    private CandidateLanguageDao candidateLanguageDao;


    @Autowired
    public CandidateLanguageManager(CandidateLanguageDao candidateLanguageDao) {
        super();
        this.candidateLanguageDao = candidateLanguageDao;
    }

    @Override
    public Result add(CandidateLanguage candidateLanguage) {
        this.candidateLanguageDao.save(candidateLanguage);
        return new SuccessResult("Yabancı dil bilgisi Eklendi.");
    }

    @Override
    public Result update(CandidateLanguage candidateLanguage) {
        CandidateLanguage language = this.candidateLanguageDao.getById(candidateLanguage.getId());
        language.setLanguage(candidateLanguage.getLanguage());
        language.setLanguageLevel(candidateLanguage.getLanguageLevel());
        this.candidateLanguageDao.save(language);
        return new SuccessResult("Dil Bilgisi Güncellendi");
    }

    @Override
    public Result delete(int id) {
        this.candidateLanguageDao.deleteById(id);
        return new SuccessResult("Dil Bilgisi Silindi.");
    }

    @Override
    public DataResult<List<CandidateLanguage>> getAll() {
        return new SuccessDataResult
                (this.candidateLanguageDao.findAll(),"Adayların yabancı dil bilgileri listelendi");
    }

    @Override
    public DataResult<CandidateLanguage> getByCandidateId(int id) {
        return new SuccessDataResult<CandidateLanguage>
                ( this.candidateLanguageDao.getBy_CandidateId(id));
    }
}
