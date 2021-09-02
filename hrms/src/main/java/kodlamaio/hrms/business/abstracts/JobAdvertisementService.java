package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concrate.JobAdvertisements;
import kodlamaio.hrms.entities.dtos.JobAdventisamentFilterDto;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementService {

	Result delete(int  id );
	Result add(JobAdvertisements jobAdertisement );

	Result update(JobAdvertisements jobAdertisement );
	
	Result changeActiveToClose(int id);
	Result changeActiveToCloseTrue(int id);

	DataResult<List<JobAdvertisements>> getAll();

	DataResult<JobAdvertisements> getById(int id);
	
	DataResult<List<JobAdvertisements>> getByActiveTrue();
	
	DataResult<List<JobAdvertisements> >getByActiveAndByCreateDateDesc();
	
	DataResult<List<JobAdvertisements>> getByActiveAndEmployerId(int id);

	DataResult<List<JobAdvertisementDto>> getJobAdvertisementDetails();

	DataResult<JobAdvertisementDto> getJobAdvertisementDetailsById(int id);
	DataResult<List<JobAdvertisements>> getFilter(int cityId,int positionId,int workingTimeId, int wayOfWorkingId);

    DataResult<List<JobAdvertisements>> getByFilter(JobAdventisamentFilterDto jobAdventisamentFilterDto, int pageNo, int pageSize);



}
