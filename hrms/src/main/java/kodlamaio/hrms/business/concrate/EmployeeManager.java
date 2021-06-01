package kodlamaio.hrms.business.concrate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.entities.concrate.Employee;

@Service
public class EmployeeManager implements EmployeeService{
	private EmployeeDao employeeDao;
	

	@Autowired
	public EmployeeManager(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		
		return new SuccessDataResult<List<Employee>> (this.employeeDao.findAll(),"Çalışanlar Listelendi.");
	}

	@Override
	public Result add(Employee employee) {
		
		
			this.employeeDao.save(employee);
			return new SuccessResult("Yeni Çalışan Eklendi.");
			
		}
	

}
