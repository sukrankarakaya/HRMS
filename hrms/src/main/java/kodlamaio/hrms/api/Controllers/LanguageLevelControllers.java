package kodlamaio.hrms.api.Controllers;

import kodlamaio.hrms.business.abstracts.CitiesService;
import kodlamaio.hrms.business.abstracts.LanguageLevelService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.entities.concrate.Cities;
import kodlamaio.hrms.entities.concrate.LanguageLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/languageLevels")
@CrossOrigin
public class LanguageLevelControllers {
    private LanguageLevelService languageLevelService;

    @Autowired
    private LanguageLevelControllers(LanguageLevelService languageLevelService){
        super();
        this.languageLevelService=languageLevelService;

    }

    @GetMapping("/getAll")
    public DataResult<List<LanguageLevel>> getAll(){
        return this.languageLevelService.getAll();

    }

}
