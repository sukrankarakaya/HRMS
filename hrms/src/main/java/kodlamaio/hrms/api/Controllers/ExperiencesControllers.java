package kodlamaio.hrms.api.Controllers;

import java.util.List;

import kodlamaio.hrms.entities.concrate.CandidateSchool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concrate.Candidate;
import kodlamaio.hrms.entities.concrate.Experience;

@RestController
@RequestMapping("api/experiances")

public class ExperiencesControllers {
	private ExperienceService experianceService;

	@Autowired
	public ExperiencesControllers(ExperienceService experianceService) {
		super();
		this.experianceService = experianceService;
	}
	
	@PostMapping(value="/add")
	public Result add(@RequestBody Experience experience) {
		return this.experianceService.add(experience);
	}
	
	@GetMapping 
	public DataResult<List<Experience>> getAll(){
		return this.experianceService.getAll();
	}



	@GetMapping("/getByEndDateDesc")
	public DataResult<List<Experience>> getByEndDateDesc(){
		return this.experianceService.getByEndDateDesc();
	}







}
