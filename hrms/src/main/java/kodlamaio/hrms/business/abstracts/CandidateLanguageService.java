package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concrate.CandidateLanguage;


import java.util.List;

public interface CandidateLanguageService {

    Result add(CandidateLanguage candidateLanguage);

    DataResult<List<CandidateLanguage>> getAll();
}
