package kodlamaio.hrms.api.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concrate.Employer;

@RestController
@RequestMapping("/api/employer")
@CrossOrigin
public class EmployerControllers {
	
	private EmployerService employerService;
	
	@Autowired
	public EmployerControllers(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Employer>> getAll(){
		return this.employerService.getAll();
		
	}
		
	@PostMapping
	public Result add(@RequestBody Employer employer) {
		return this.employerService.add(employer);
		}
}

	