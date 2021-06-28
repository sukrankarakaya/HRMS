package kodlamaio.hrms.business.abstracts;

import java.util.List;


import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concrate.JobAdvertisements;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementService {
	Result add(JobAdvertisements jobAdertisement );
	
	Result update(JobAdvertisements jobAdertisement );
	
	Result changeActiveToClose(int id);
	
	DataResult<JobAdvertisements> getById(int id);
	
	DataResult<List<JobAdvertisements>> getByActiveTrue();
	
	DataResult<List<JobAdvertisements> >getByActiveAndByCreateDateDesc();
	
	DataResult<List<JobAdvertisements>> getByActiveAndEmployerId(int id);

	/*DataResult<List<JobAdvertisementDto>> getJobAdvertisementDetails();
	
	*/
}
