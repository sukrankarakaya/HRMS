package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;

import kodlamaio.hrms.entities.concrate.CandidateCoverLetter;
import kodlamaio.hrms.entities.concrate.CandidateLanguage;
import kodlamaio.hrms.entities.concrate.CandidateSchool;

import java.util.List;

public interface CandidateSchoolService {
    Result add(CandidateSchool candidateSchool);
    Result update(CandidateSchool candidateSchool);

    Result delete(int id);
    DataResult<List<CandidateSchool>> getAll();
    DataResult<List<CandidateSchool>> getByCandidateId(int id);
}
