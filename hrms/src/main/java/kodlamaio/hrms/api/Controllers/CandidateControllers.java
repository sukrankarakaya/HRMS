package kodlamaio.hrms.api.Controllers;

import java.util.List;

import kodlamaio.hrms.entities.concrate.CandidateCoverLetter;
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
@CrossOrigin
public class CandidateControllers {
	

	private CandidateService candidateservice;

	@Autowired
	public CandidateControllers(CandidateService candidateservice) {
		super();
		this.candidateservice = candidateservice;
	}
	

	@GetMapping ("/getAll")
	public DataResult<List<Candidate>> getAll(){

		return this.candidateservice.getAll();
	}
	
	@PostMapping(value="/add")
	public Result add(@RequestBody Candidate candidate) {
		return this.candidateservice.add(candidate);
	}


	@DeleteMapping("/delete")
	public Result delete(int id) {
		return this.candidateservice.delete(id);
	}

	@GetMapping("/getCandidateCVById")
	public DataResult<CvDto> getCandidateCVById(@RequestParam int id){
		return this.candidateservice.getCandidateCVById(id);
	}

	@GetMapping("/getById")
	public DataResult<Candidate> getById(@RequestParam int id){
		return this.candidateservice.getById(id);
	}


	@PutMapping("/update")
	public Result update(@RequestBody Candidate candidate){
		return this.candidateservice.update(candidate);}


}
