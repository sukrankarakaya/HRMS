package kodlamaio.hrms.api.Controllers;

import kodlamaio.hrms.business.abstracts.CandidateSchoolService;
import kodlamaio.hrms.business.abstracts.SocialMediaService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.dataAccess.abstracts.SocialMediaDao;
import kodlamaio.hrms.entities.concrate.CandidateSchool;
import kodlamaio.hrms.entities.concrate.SocialMedia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/socialMedia")
public class SocialMediaControllers {

    private SocialMediaService socialMediaService;

    @Autowired
    public SocialMediaControllers(SocialMediaService socialMediaService){
        super();
        this.socialMediaService=socialMediaService;
    }

    @GetMapping("/getAll")
    public DataResult<List<SocialMedia>> getAll(){
        return this.socialMediaService.getAll();

    }

    @PostMapping(value = "/add")
    public Result add(@RequestBody SocialMedia socialMedia) {

        return this.socialMediaService.add(socialMedia);
    }

}
