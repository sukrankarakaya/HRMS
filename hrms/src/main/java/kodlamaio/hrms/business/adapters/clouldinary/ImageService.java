package kodlamaio.hrms.business.adapters.clouldinary;

import kodlamaio.hrms.core.utilities.result.DataResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface ImageService {

    DataResult<Map> uploadImageFile(MultipartFile imageFile);
}
