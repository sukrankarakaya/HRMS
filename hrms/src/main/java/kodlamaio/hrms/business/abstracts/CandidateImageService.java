package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concrate.CandidateImage;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CandidateImageService {
    Result add(CandidateImage candidateImage, MultipartFile imageFile);
    DataResult<List<CandidateImage>> getAll();


}
