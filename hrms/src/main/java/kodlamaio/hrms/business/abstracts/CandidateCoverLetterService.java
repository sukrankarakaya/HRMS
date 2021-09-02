package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCoverLetterDao;
import kodlamaio.hrms.entities.concrate.Candidate;
import kodlamaio.hrms.entities.concrate.CandidateCoverLetter;

import java.util.List;

public interface CandidateCoverLetterService {
    Result add(CandidateCoverLetter candidateCoverLetter);
    Result delete(int id);
    Result update(CandidateCoverLetter candidateCoverLetter);
    DataResult<List<CandidateCoverLetter>> getAll();

    DataResult<CandidateCoverLetter> gtById(int id);

    DataResult<CandidateCoverLetter> getByCandidateId(int id);
}
