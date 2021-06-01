package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concrate.Employee;

public interface EmployeeService {

	DataResult<List<Employee>> getAll();
	Result add(Employee employee);
	
	
	
}
