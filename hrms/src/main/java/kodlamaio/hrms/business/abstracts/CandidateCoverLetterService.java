package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCoverLetterDao;
import kodlamaio.hrms.entities.concrate.CandidateCoverLetter;
import kodlamaio.hrms.entities.concrate.CandidateSchool;

import java.util.List;

public interface CandidateCoverLetterService {

    Result add(CandidateCoverLetter candidateCoverLetter);

    DataResult<List<CandidateCoverLetter>> getAll();
}
