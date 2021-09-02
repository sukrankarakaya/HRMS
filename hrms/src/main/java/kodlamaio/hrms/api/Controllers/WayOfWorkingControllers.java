package kodlamaio.hrms.api.Controllers;


import kodlamaio.hrms.business.abstracts.WayOfWorkingService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.entities.concrate.WayOfWorking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/wayOfWorking")
@CrossOrigin

public class WayOfWorkingControllers {

    private WayOfWorkingService wayOfWorkingService;

    @Autowired
    public WayOfWorkingControllers(WayOfWorkingService wayOfWorkingService){
        super();
        this.wayOfWorkingService=wayOfWorkingService;
    }
    @GetMapping("/getAll")
        public DataResult<List<WayOfWorking>> getAll(){
        return this.wayOfWorkingService.getAll();

    }
}
