package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concrate.Experience;
import kodlamaio.hrms.entities.concrate.Technologies;

import java.util.List;

public interface TechnologyService {

    Result add(Technologies technologies);

    DataResult<List<Technologies>> getAll();

}


