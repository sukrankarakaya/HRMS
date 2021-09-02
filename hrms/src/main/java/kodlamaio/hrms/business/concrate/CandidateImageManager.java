package kodlamaio.hrms.business.concrate;

import kodlamaio.hrms.business.abstracts.CandidateImageService;
import kodlamaio.hrms.business.adapters.clouldinary.ImageManager;
import kodlamaio.hrms.business.adapters.clouldinary.ImageService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateImageDao;
import kodlamaio.hrms.entities.concrate.CandidateCoverLetter;
import kodlamaio.hrms.entities.concrate.CandidateImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public class CandidateImageManager implements CandidateImageService {
    private CandidateImageDao candidateImageDao;
    private ImageService imageService;

    @Autowired
    public CandidateImageManager(CandidateImageDao candidateImageDao, ImageService imageService){
        super();
        this.candidateImageDao=candidateImageDao;
        this.imageService=imageService;

    }


    @Override
    public Result add(CandidateImage candidateImage, MultipartFile imageFile) {
        Map<String,String> image=this.imageService.uploadImageFile(imageFile).getData() ;

        candidateImage.setImageUrl(image.get("url"));

        this.candidateImageDao.save(candidateImage);
        return  new SuccessResult("Resim eklendi.");
    }

    @Override
    public Result delete(int id) {
        this.candidateImageDao.deleteById(id);
        return new SuccessResult("Fotagraf Silindi.");
    }

    @Override
    public DataResult<List<CandidateImage>> getAll() {
        return new SuccessDataResult<List<CandidateImage>>(this.candidateImageDao.findAll(),"Resimler Listelendi.");
    }

    @Override
    public DataResult<CandidateImage> getByCandidateId(int id) {
        return new SuccessDataResult<CandidateImage>
                ( this.candidateImageDao.getBy_CandidateId(id));
    }
}
