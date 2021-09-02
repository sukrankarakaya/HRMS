package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concrate.Favorites;
import kodlamaio.hrms.entities.concrate.SocialMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.jsf.FacesContextUtils;

import java.util.List;

public interface FavoriteDao extends JpaRepository<Favorites,Integer> {

    Favorites getByFavoriteId(int favoriteId);

    @Query("From Favorites where  candidate.id=:id")
    List<Favorites> getByCandidateId(int id);


}
