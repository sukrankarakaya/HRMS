package kodlamaio.hrms.api.Controllers;

import kodlamaio.hrms.business.abstracts.CandidateCoverLetterService;
import kodlamaio.hrms.business.concrate.CandidateCoverLetterManager;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concrate.CandidateCoverLetter;
import kodlamaio.hrms.entities.concrate.CandidateSchool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/candidateCoverLetters")


public class CandidateCoverLetterController {
    public CandidateCoverLetterService candidateCoverLetterService;

    @Autowired
    public CandidateCoverLetterController(CandidateCoverLetterService candidateCoverLetterService){
        super();
        this.candidateCoverLetterService=candidateCoverLetterService;
    }

    @PostMapping(name = "/add")
    public Result add(@RequestBody CandidateCoverLetter candidateCoverLetter) {
        return this.candidateCoverLetterService.add(candidateCoverLetter);
    }

    @GetMapping("/getAll")
    public DataResult<List<CandidateCoverLetter>> getAll(){
        return this.candidateCoverLetterService.getAll();

    }
}
