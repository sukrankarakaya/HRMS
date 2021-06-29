package kodlamaio.hrms.business.adapters.clouldinary;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class ImageManager implements ImageService{

    private Cloudinary cloudinary;

    public ImageManager() {

        this.cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "sukran",
                "api_key", "558189185894147",
                "api_secret", "LixeObHr-1HM6ZiN0wU3M30_SSg"));

    }


    @Override
    public DataResult<Map> uploadImageFile(MultipartFile imageFile) {
        try {
            @SuppressWarnings("unchecked")
            Map<String, String> resultMap =(Map<String, String>) cloudinary.uploader().upload(imageFile.getBytes(), ObjectUtils.emptyMap());
            return new SuccessDataResult<Map>(resultMap);
        } catch (IOException e) {

            e.printStackTrace();

        }
        return new ErrorDataResult<Map>();
    }
}
