package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.entities.concrate.WorkingTime;


import java.util.List;

public interface WorkingTimeService {
    DataResult<List<WorkingTime>> getAll();
}
