package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.entities.concrate.WayOfWorking;

import java.util.List;

public interface WayOfWorkingService {

    DataResult<List<WayOfWorking>> getAll();

}
