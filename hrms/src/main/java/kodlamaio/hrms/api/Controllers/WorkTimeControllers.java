package kodlamaio.hrms.api.Controllers;

import kodlamaio.hrms.business.abstracts.WorkingTimeService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.entities.concrate.WorkingTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/workingTime")
@CrossOrigin
public class WorkTimeControllers {
   private WorkingTimeService workingTimeService;

    @Autowired
    public WorkTimeControllers(WorkingTimeService workingTimeService){
        super();
        this.workingTimeService= workingTimeService;
    }

    @GetMapping("/getAll")
    public DataResult<List<WorkingTime>> getAll() {
        return this.workingTimeService.getAll();
    }
}
