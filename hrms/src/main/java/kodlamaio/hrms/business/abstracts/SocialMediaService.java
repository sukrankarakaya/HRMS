package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;

import kodlamaio.hrms.entities.concrate.CandidateCoverLetter;
import kodlamaio.hrms.entities.concrate.CandidateLanguage;
import kodlamaio.hrms.entities.concrate.SocialMedia;
import kodlamaio.hrms.entities.concrate.Technologies;


import java.util.List;

public interface SocialMediaService {
    Result add(SocialMedia socialMedia);
    Result update(SocialMedia socialMedia);

    Result delete(int id);
    DataResult<List<SocialMedia>> getAll();
    DataResult<SocialMedia> getByCandidateId(int id);
}
