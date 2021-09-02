package kodlamaio.hrms.business.concrate;

import kodlamaio.hrms.business.abstracts.WorkingTimeService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.WorkingTimeDao;
import kodlamaio.hrms.entities.concrate.WorkingTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkingTimeManager implements WorkingTimeService  {
   private WorkingTimeDao workingTimeDao;

   @Autowired
   public WorkingTimeManager(WorkingTimeDao workingTimeDao){

       super();
       this.workingTimeDao= workingTimeDao;

   }

    @Override
    public DataResult<List<WorkingTime>> getAll() {
        return new SuccessDataResult<>(this.workingTimeDao.findAll(),"Data listelendi");
    }
}
