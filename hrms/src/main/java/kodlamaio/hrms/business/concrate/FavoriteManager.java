package kodlamaio.hrms.business.concrate;

import kodlamaio.hrms.business.abstracts.FavoriteService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.FavoriteDao;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concrate.Favorites;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FavoriteManager implements FavoriteService {

    private FavoriteDao favoriteDao;
    private CandidateDao candidateDao;
    private JobAdvertisementDao jobAdvertisementDao;

    @Autowired
    public FavoriteManager(FavoriteDao favoriteDao , CandidateDao candidateDao, JobAdvertisementDao jobAdvertisementDao) {
        super();
        this.favoriteDao = favoriteDao;
        this.candidateDao=candidateDao;
        this.jobAdvertisementDao=jobAdvertisementDao;

    }



    @Override
    public Result delete(int favoriteId) {
        this.favoriteDao.deleteById(favoriteId);
        return  new SuccessResult("Favorilerden Silindi.");
    }

    @Override
    public Result add(int jobAdvertisementId, int candidateId) {
        Favorites favorites= new Favorites();
        favorites.setCandidate(this.candidateDao.getById(candidateId));
        favorites.setJobAdvertisements(this.jobAdvertisementDao.getById(jobAdvertisementId));

        this.favoriteDao.save(favorites);
        return new SuccessResult("Favorilere Eklendi.");

    }

//    @Override
//    public Result add(Favorites favorites) {
//
//        this.favoriteDao.save(favorites);
//        return new SuccessResult("Favorilere Eklendi");
//
//    }

    @Override
    public DataResult<Favorites> getByFavoriteId(int favoriteId) {
        return new SuccessDataResult<Favorites>(this.favoriteDao.getByFavoriteId(favoriteId),"Favori İlan Getirildi.");
    }

    @Override
    public DataResult<List<Favorites>> getByCandidateId(int id) {
        return new SuccessDataResult<List<Favorites>>(this.favoriteDao.getByCandidateId(id),"Favori İlanlar Listelendi.");
    }


}
