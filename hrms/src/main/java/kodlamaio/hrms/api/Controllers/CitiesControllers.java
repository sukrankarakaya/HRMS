package kodlamaio.hrms.api.Controllers;

import kodlamaio.hrms.business.abstracts.CitiesService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.entities.concrate.Cities;
import kodlamaio.hrms.entities.concrate.WayOfWorking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
@CrossOrigin
public class CitiesControllers {
    private CitiesService citiesService;

    @Autowired
    private CitiesControllers(CitiesService citiesService){
        super();
        this.citiesService=citiesService;

    }

    @GetMapping("/getAll")
    public DataResult<List<Cities>> getAll(){
        return this.citiesService.getAll();

    }
}
