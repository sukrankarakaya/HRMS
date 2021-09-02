package kodlamaio.hrms.api.Controllers;

import kodlamaio.hrms.business.abstracts.FavoriteService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concrate.Favorites;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/Favorite")
@CrossOrigin
public class FavoriteControllers {

    private FavoriteService favoriteService;

    @Autowired
    public FavoriteControllers(FavoriteService favoriteService) {
        super();
        this.favoriteService = favoriteService;

    }
    @PostMapping("/add")
    public Result add( int jobAdvertisementId,int candidateId) {
        return this.favoriteService.add(jobAdvertisementId,candidateId);
    }


//    @PostMapping("/add")
//    public Result add(@RequestBody Favorites favorites ) {
//        return this.favoriteService.add(favorites);
//    }

    @DeleteMapping("/delete")
    public  Result deleteById(int favoriteId){
        return this.favoriteService.delete(favoriteId);
    }

    @GetMapping("/getByFavoriteId")
    public DataResult<Favorites> getByFavoriteId(int favoriteId){
        return  this.favoriteService.getByFavoriteId(favoriteId);
    }

    @GetMapping("/getByCandidateId")
    public DataResult<List<Favorites>> getByCandidateId(int candidateId){
        return  this.favoriteService.getByCandidateId(candidateId);
    }


}
