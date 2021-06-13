package kodlamaio.hrms.business.abstracts;

import java.util.List;


import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concrate.JobAdvertisements;

public interface JobAdvertisementService {
	Result add(JobAdvertisements jobAdertisement );

	DataResult<List<JobAdvertisements>> getByActiveTrue();
	
	DataResult<List<JobAdvertisements> >getByActiveAndByCreateDateDesc();
	
	DataResult<List<JobAdvertisements>> getByActiveAndEmployerId(int id);

	
}
