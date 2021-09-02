package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concrate.CandidateCoverLetter;
import kodlamaio.hrms.entities.concrate.CandidateLanguage;


import java.util.List;

public interface CandidateLanguageService {

    Result add(CandidateLanguage candidateLanguage);

    Result update(CandidateLanguage candidateLanguage);
    Result delete(int id);
    DataResult<List<CandidateLanguage>> getAll();
    DataResult<CandidateLanguage> getByCandidateId(int id);
}
