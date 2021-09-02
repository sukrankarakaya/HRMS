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
   private CandidateCoverLetterService candidateCoverLetterService;

   @Autowired
   public  CandidateCoverLetterManager(CandidateCoverLetterDao candidateCoverLetterDao){
       super();
       this.candidateCoverLetterDao=candidateCoverLetterDao;
       this.candidateCoverLetterService=candidateCoverLetterService;
   }

    @Override
    public Result add(CandidateCoverLetter candidateCoverLetter) {
        this.candidateCoverLetterDao.save(candidateCoverLetter);
        return new SuccessDataResult("Ön Yazı Eklendi.");
    }

    @Override
    public Result delete(int id) {
       this.candidateCoverLetterDao.deleteById(id);
        return new SuccessResult("Ön Yazı Silindi.");

    }

    @Override
    public Result update(CandidateCoverLetter candidateCoverLetter) {
       CandidateCoverLetter coverLetter = this.candidateCoverLetterDao.getById(candidateCoverLetter.getId());
       coverLetter.setCoverLetter(candidateCoverLetter.getCoverLetter());
      this.candidateCoverLetterDao.save(coverLetter);
       return new SuccessResult("Güncellendi");

   }

    @Override
    public DataResult<List<CandidateCoverLetter>> getAll() {
        return new SuccessDataResult(this.candidateCoverLetterDao.findAll(),"Ön Yazılar Listelendi.");
    }

    @Override
    public DataResult<CandidateCoverLetter> gtById(int id) {
        this.candidateCoverLetterDao.getById(id);
        return new SuccessDataResult<>("Ön yazi bilgisi getirildi");
    }

    @Override
    public DataResult<CandidateCoverLetter>getByCandidateId(int id) {

        return new SuccessDataResult<CandidateCoverLetter>
                ( this.candidateCoverLetterDao.getBy_CandidateId(id));
   }

}
