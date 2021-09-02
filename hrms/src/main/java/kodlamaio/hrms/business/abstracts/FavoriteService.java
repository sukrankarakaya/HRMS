package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.dataAccess.abstracts.FavoriteDao;
import kodlamaio.hrms.entities.concrate.Favorites;
import kodlamaio.hrms.entities.concrate.JobAdvertisements;

import java.util.List;

public interface FavoriteService {

    Result delete(int  favoriteId );
   // Result add(Favorites favorites);
    Result add(int jobAdvertisementId, int candidateId);

    DataResult<Favorites> getByFavoriteId(int favoriteId);
    DataResult<List<Favorites>> getByCandidateId(int id);
}
