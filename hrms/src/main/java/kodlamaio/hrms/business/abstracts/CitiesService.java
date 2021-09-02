package kodlamaio.hrms.business.abstracts;


import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.entities.concrate.Cities;

import java.util.List;

public interface CitiesService {
    DataResult<List<Cities>> getAll();

}
