package kodlamaio.hrms.business.concrate;

import kodlamaio.hrms.business.abstracts.WayOfWorkingService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.WayOfWorkingDao;
import kodlamaio.hrms.entities.concrate.WayOfWorking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WayOfWorkingManager implements WayOfWorkingService {

    private WayOfWorkingDao wayOfWorkingDao;

    @Autowired
    public WayOfWorkingManager(WayOfWorkingDao wayOfWorkingDao){
        super();
        this.wayOfWorkingDao=wayOfWorkingDao;
    }

    @Override
    public DataResult<List<WayOfWorking>> getAll() {
        return new SuccessDataResult<List<WayOfWorking>>
                (this.wayOfWorkingDao.findAll(),"Data listelendi.");
    }
}
