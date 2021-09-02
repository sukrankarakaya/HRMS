package kodlamaio.hrms.api.Controllers;

import java.util.List;

import kodlamaio.hrms.entities.concrate.CandidateCoverLetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concrate.Candidate;
import kodlamaio.hrms.entities.concrate.Experience;

@RestController
@RequestMapping("api/experiances")
@CrossOrigin
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
	
	@GetMapping ("/getAll")
	public DataResult<List<Experience>> getAll(){
		return this.experianceService.getAll();
	}

	@DeleteMapping("/delete")
	public  Result delete( int id){
		return  this.experianceService.delete(id);
	}

	@GetMapping("/getByCandidateId")

	public DataResult<Experience> getByCandidateId(int id){
		return this.experianceService.getByCandidateId(id);
	}

	@PutMapping("/update")
	public Result update(@RequestBody Experience experience){
		return this.experianceService.update(experience);}

}
