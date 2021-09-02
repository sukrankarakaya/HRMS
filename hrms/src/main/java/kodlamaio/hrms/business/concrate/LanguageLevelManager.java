package kodlamaio.hrms.business.concrate;

import kodlamaio.hrms.business.abstracts.LanguageLevelService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.LanguageLevelDao;
import kodlamaio.hrms.entities.concrate.LanguageLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageLevelManager implements LanguageLevelService {


private LanguageLevelDao languageLevelDao;

@Autowired
    public  LanguageLevelManager(LanguageLevelDao languageLevelDao){
    super();
    this.languageLevelDao=languageLevelDao;
}


    @Override
    public DataResult<List<LanguageLevel>> getAll() {
        return new SuccessDataResult<List<LanguageLevel>>
                (this.languageLevelDao.findAll(),"Data Listelendi.");
    }
}
