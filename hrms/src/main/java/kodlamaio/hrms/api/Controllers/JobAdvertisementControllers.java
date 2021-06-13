package kodlamaio.hrms.api.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concrate.JobAdvertisements;

@RestController
@RequestMapping("/api/JobAdvertisements")
public class JobAdvertisementControllers {

	private JobAdvertisementService JobAdvertisemtService;


	@Autowired
	public JobAdvertisementControllers(JobAdvertisementService jobAdvertisemtService) {
		super();
		JobAdvertisemtService = jobAdvertisemtService;
	} 
	
	@PostMapping
	public Result add(@RequestBody JobAdvertisements JobAdvertimsement) {
		return this.JobAdvertisemtService.add(JobAdvertimsement);
	}

	
	@PostMapping("/changeActiveToClose")
	public Result changeActiveToClose(int id) {
		return this.JobAdvertisemtService.changeActiveToClose(id);
	}
	
	
//	@GetMapping("/getById")
//	public DataResult<JobAdvertisements> getById(int id){
//		return this.JobAdvertisemtService.getById(id);
//	}
//	
	@GetMapping("/getAllActiveTrue")
	public DataResult<List<JobAdvertisements>> getAllActiveTrue(){
		return this.JobAdvertisemtService.getByActiveTrue();
	}
	@GetMapping("/getByActiveAndByCreateDateDesc")
	public DataResult<List<JobAdvertisements>> getByActiveAndByCreateDateDesc(){
		return this.JobAdvertisemtService.getByActiveAndByCreateDateDesc();
	}

	@GetMapping("/getByActiveAndEmployerId")
	public DataResult<List<JobAdvertisements>> getByActiveAndEmployerId(int id){
		return this.JobAdvertisemtService.getByActiveAndEmployerId(id);
	}
	
	
	
}
