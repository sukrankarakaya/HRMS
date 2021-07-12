package kodlamaio.hrms.api.Controllers;

import kodlamaio.hrms.business.abstracts.CandidateImageService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.entities.concrate.Candidate;
import kodlamaio.hrms.entities.concrate.CandidateImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(("/api/candidateImage"))

@CrossOrigin

public class CandidateImageControllers {

    private CandidateImageService candidateImageService;
    private CandidateService candidateService;

    @Autowired
    public CandidateImageControllers(CandidateImageService candidateImageService, CandidateService candidateService){
        super();
        this.candidateImageService=candidateImageService;
        this.candidateService=candidateService;

    }

    @PostMapping(value = "/add")
    public Result add(@RequestParam (value = "id") int id, @RequestParam(value = "imageFile")MultipartFile imageFile){
        Candidate candidate =this.candidateService.getById(id).getData();
        CandidateImage candidateImage=new CandidateImage();
        candidateImage.setCandidate(candidate);
        return this.candidateImageService.add(candidateImage,imageFile);

    }

    @GetMapping("/getAll")

    public DataResult<List<CandidateImage>> getAll(){
        return this.candidateImageService.getAll();
    }






}
