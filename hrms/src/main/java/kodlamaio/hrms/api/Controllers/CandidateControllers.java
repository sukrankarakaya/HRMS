package kodlamaio.hrms.api.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
}
