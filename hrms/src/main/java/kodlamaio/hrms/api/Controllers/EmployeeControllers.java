package kodlamaio.hrms.api.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concrate.Employee;

@RestController
@RequestMapping("/api/employeies")
@CrossOrigin
public class EmployeeControllers {
	
	private EmployeeService employeeService;

	@Autowired
	public EmployeeControllers(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employee>> getAll(){
		return this.employeeService.getAll();
	}


	@PostMapping("/add")
	public Result add(@RequestBody Employee employee) {
		return this.employeeService.add(employee);
	}

	@DeleteMapping("/delete")

	public  Result delete( int id){
		return  this.employeeService.delete(id);
	}

}
