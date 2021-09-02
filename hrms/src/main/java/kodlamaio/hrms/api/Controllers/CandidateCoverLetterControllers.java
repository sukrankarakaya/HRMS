package kodlamaio.hrms.api.Controllers;

import kodlamaio.hrms.business.abstracts.CandidateCoverLetterService;
import kodlamaio.hrms.business.abstracts.CandidateSchoolService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concrate.CandidateCoverLetter;
import kodlamaio.hrms.entities.concrate.CandidateLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidateCoverLetter")
@CrossOrigin
public class CandidateCoverLetterControllers {
    private CandidateCoverLetterService candidateCoverLetterService;

    @Autowired
    public CandidateCoverLetterControllers(CandidateCoverLetterService candidateCoverLetterService){
        super();
        this.candidateCoverLetterService=candidateCoverLetterService;
    }

    @PostMapping("/add")

    public Result add(@RequestBody CandidateCoverLetter candidateCoverLetter){
        return this.candidateCoverLetterService.add(candidateCoverLetter);
    }
    @GetMapping("/getAll")

    public DataResult<List<CandidateCoverLetter>> getAll(){
        return this.candidateCoverLetterService.getAll();
    }

    @GetMapping("/getByCandidateId")

    public DataResult<CandidateCoverLetter> getByCandidateId(int id){
        return this.candidateCoverLetterService.getByCandidateId(id);
    }

    @DeleteMapping("/delete")

    public  Result delete(@RequestBody int id){
        return  this.candidateCoverLetterService.delete(id);
    }


    @PutMapping("/update")
    public Result update(@RequestBody CandidateCoverLetter candidateCoverLetter){
        return this.candidateCoverLetterService.update(candidateCoverLetter);}

}
