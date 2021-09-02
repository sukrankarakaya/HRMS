package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concrate.CandidateCoverLetter;
import kodlamaio.hrms.entities.concrate.CandidateLanguage;
import kodlamaio.hrms.entities.concrate.Technologies;

import java.util.List;

public interface TechnologyService {

    Result add(Technologies technologies);
    Result update(Technologies technologies);

    Result delete(int id);
    DataResult<List<Technologies>> getAll();
    DataResult<Technologies> getByCandidateId(int id);

}


