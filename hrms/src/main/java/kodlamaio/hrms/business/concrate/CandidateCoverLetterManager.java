package kodlamaio.hrms.business.concrate;

import kodlamaio.hrms.business.abstracts.CandidateCoverLetterService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCoverLetterDao;
import kodlamaio.hrms.entities.concrate.CandidateCoverLetter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateCoverLetterManager implements CandidateCoverLetterService {

    private CandidateCoverLetterDao candidateCoverLetterDao;

    @Autowired
    public CandidateCoverLetterManager(CandidateCoverLetterDao candidateCoverLetterDao){
        super();
        this.candidateCoverLetterDao=candidateCoverLetterDao;

    }


    @Override
    public Result add(CandidateCoverLetter candidateCoverLetter) {
        this.candidateCoverLetterDao.save(candidateCoverLetter);
        return new SuccessResult("Ön yazı eklendi.");

    }

    @Override
    public DataResult<List<CandidateCoverLetter>> getAll() {
        return new SuccessDataResult<>(this.candidateCoverLetterDao.findAll(), "Ön yazılar listelendi.");
    }
}
