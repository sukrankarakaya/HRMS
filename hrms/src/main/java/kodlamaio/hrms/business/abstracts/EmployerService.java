package kodlamaio.hrms.business.abstracts;

import java.util.List;


import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concrate.Employer;
import kodlamaio.hrms.entities.concrate.Experience;


public interface EmployerService{
	
	 DataResult<List<Employer> > getAll();
	 Result add(Employer employer);
	 Result delete(int id);
	 Result update(Employer employer);
	 DataResult<Employer> getById(int id);


}
