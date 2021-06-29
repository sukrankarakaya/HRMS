package kodlamaio.hrms.api.Controllers;

import java.util.List;

import kodlamaio.hrms.entities.dtos.CvDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concrate.Candidate;
import kodlamaio.hrms.entities.concrate.VerificationCode;

@RestController
@RequestMapping("/api/candidates")
public class CandidateControllers {
	

	private CandidateService candidateservice;

	@Autowired
	public CandidateControllers(CandidateService candidateservice) {
		super();
		this.candidateservice = candidateservice;
	}
	

	@GetMapping 
	public DataResult<List<Candidate>> getAll(){

		return this.candidateservice.getAll();
	}
	
	@PostMapping(value="/add")
	public Result add(@RequestBody Candidate candidate) {
		return this.candidateservice.add(candidate);
	}


	@DeleteMapping
	public Result deleteById(@RequestBody int id) {
		return this.candidateservice.delete(id);
	}

	@GetMapping("/getCandidateCVById")
	public DataResult<CvDto> getCandidateCVById(@RequestParam int id){
		return this.candidateservice.getCandidateCVById(id);
	}




}
