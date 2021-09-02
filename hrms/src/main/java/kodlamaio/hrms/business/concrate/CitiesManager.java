package kodlamaio.hrms.business.concrate;

import kodlamaio.hrms.business.abstracts.CitiesService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.CitiesDao;
import kodlamaio.hrms.entities.concrate.Cities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitiesManager implements CitiesService {

    private CitiesDao citiesDao;

    @Autowired
    private CitiesManager(CitiesDao citiesDao){
        super();
        this.citiesDao=citiesDao;
    }



    @Override
    public DataResult<List<Cities>> getAll() {
        return new SuccessDataResult<List<Cities>>
                (this.citiesDao.findAll(),"Data listelendi");


    }
}
