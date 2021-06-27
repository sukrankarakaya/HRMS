package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;

import kodlamaio.hrms.entities.concrate.SocialMedia;


import java.util.List;

public interface SocialMediaService {
    Result add(SocialMedia socialMedia);

    DataResult<List<SocialMedia>> getAll();
}
