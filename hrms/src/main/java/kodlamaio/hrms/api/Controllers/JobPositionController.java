package kodlamaio.hrms.api.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concrate.JobPosition;

@RestController
@RequestMapping("/api/jobpositions")
@CrossOrigin

public class JobPositionController {
	
	private JobPositionService jobPositionService;

	@Autowired
	public JobPositionController(JobPositionService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	}
	
	
	@GetMapping("/getAll")
	public DataResult< List<JobPosition>> getAll(){
		return this.jobPositionService.getAll();
		
	}
	
	@PostMapping
	public Result add(@RequestBody JobPosition jobPositon) {
		return this.jobPositionService.add(jobPositon);
	}
	
	 
	
	
	

}
