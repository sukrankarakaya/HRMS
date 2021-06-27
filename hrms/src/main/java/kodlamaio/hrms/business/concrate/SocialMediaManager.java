package kodlamaio.hrms.business.concrate;

import kodlamaio.hrms.business.abstracts.SocialMediaService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;

import kodlamaio.hrms.dataAccess.abstracts.SocialMediaDao;

import kodlamaio.hrms.entities.concrate.SocialMedia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialMediaManager implements SocialMediaService {

    private SocialMediaDao socialMediaDao;


    @Autowired
    public SocialMediaManager(SocialMediaDao socialMediaDao) {
        super();
        this.socialMediaDao = socialMediaDao;
    }



    @Override
    public Result add(SocialMedia socialMedia) {
        this.socialMediaDao.save(socialMedia);
        return new SuccessResult("Sosyal medyalar eklendi.");

    }

    @Override
    public DataResult<List<SocialMedia>> getAll() {
        return new SuccessDataResult<List<SocialMedia>>
                (this.socialMediaDao.findAll(),"Data Listelendi.");
    }
}
